#!/bin/bash

usage="$(basename $0) [-hnf] [-o output] logfile [logfile [...]]

Count the unique ip addresses in a log file, approximate
the country of origin and print the results as a table to
an output file.

    -h          print this help message
    -n          print to stdout instead of file
    -o output   file to write html table to
    -f          force overwriting existing files."

################
# Exercise 1
function exercise1 {
	awk '{print $1}' $* | sort | uniq -c | sort -nr | head
}

################
# Exercise 2
function exercise2 {

	while read ip; do

		# Compare the read line with an ip regex. If it doesn't match, print an
		# error message to stderr and skip the rest of this loop.
		# if ! [[ "$ip" =~ ^([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})$ ]];
		if ! [[ "$ip" =~ ^([0-9]{1,3}[.]){3}([0-9]{1,3})$ ]];
		then
			echo "Input is not a valid ip address, only ipv4 supported by freegeoip.net" >&2
			continue
		fi

		# Download the data from freegeoip
		data=$(curl --silent http://freegeoip.net/csv/"$ip" | tr --delete "\"")

		# Extract the first two fields
		ipData[0]=$(awk -F "," '{print $1}' <<< "$data")
		ipData[1]=$(awk -F "," '{print $2}' <<< "$data")
	done
}

function write {
	if $toFile; then
		echo "$1" >> $outputFile
	else
		echo "$1"
	fi
}

################
# Exercise 3

outputFile="table.html"
while getopts "hno:f" opt; do
	case "$opt" in
		h)
			echo "$usage"
			exit 0
			;;
		n)
			toFile=false
			;;
		o)
			outputFile=${OPTARG}
			;;
		f)
			overwrite=true
			;;
		*)
			echo "Flag "$opt" not recognised."
			echo "$usage"
			exit 0
			;;
	esac
done
shift $((OPTIND-1))

#### Start script ####

# Clear output file
if $toFile; then
	if [[ ! -e "$outputFile" || "$overwrite" ]]; then
		>"$outputFile"
	else
		echo "Error: File exists."
		exit 0
	fi
fi

# Use ex1 to get ips with counts from files
ipWithCounts=$(exercise1 $*)

htmlHeader="<style>
table,th,td {
	border:1px solid black;
	border-collapse:collapse;
	font-family:monospace
}
</style>
<table>
	<tr>
		<th>Count</th>
		<th>IP</th>
		<th>Country</th>
	</tr>"

write "$htmlHeader"

# For each line of the data from ex1
innerTable=$(while read line; do

	echo "	<tr>"

	# Read the line into an array so that all elements are accessible, but we
	# can opperate on them separately. array[0] = count, array[1] = ip
	read -a array <<< $line

	# Print the count then use ex2 to get the country.
	echo "		<td>"${array[0]}"</td>"
		exercise2 <<< "${array[1]}"
		echo "		<td>${ipData[0]}</td>"
		echo "		<td>${ipData[1]}</td>"
	echo "	</tr>"

done <<< "$ipWithCounts")

write "$innerTable"

write "</table>"
