#!/bin/bash

################
# Exercise 1
function exercise1() {
	awk '{print $1}' $* | sort | uniq -c | sort -nr | head
}

################
# Exercise 2
function exercise2() {

	if [[ "$1" == "-u" ]]; then
		unquote=true
		shift
	fi

	while read ip; do

		# Compare the read line with an ip regex. If it doesn't match, print an
		# error message to stderr and skip the rest of this loop.
		if ! [[ "$ip" =~ ^([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})$ ]];
		then
			echo "Input is not a valid ip address" >&2
			continue
		fi

		# Download the data from freegeoip
		data=$(curl -s http://freegeoip.net/csv/"$ip")

		# Extract the first two fields, as separated by comma.
		specData=$(awk -F "," '{print $1 "," $2}' <<< "$data")

		# if the option to unquote the final text was given, delete all quote
		# characters from the string.
		if $unquote ; then
			specData=$(tr -d "\"" <<< "$specData")
		fi

		# Print the final data, should be of the form
		# xxx.xxx.xxx.xxx,AA      or
		# "xxx.xxx.xxx.xxx","AA"
		echo "$specData"
	done
}

################
# Exercise 3
usage="$(basename "$0") [-hu] [log file [log file [...]]]
Prints the estimated country code and the count
of the top 10 most common ip addresses in the
given file using the service at freegeoip.net.

Reads from stdin, a standard format apache log
file, or similar, where the ip address appears
at the start of each line.

where:
	-h  show this help text
	-u  return the data without quotes."

if [[ "$1" == "-h" ]]; then
	echo "$usage"
	exit 0
fi

if [[ "$1" == "-u" ]]; then
	unquote=$1
	shift
fi

#### Start script ####

# Use ex1 to get ips with counts from files
ipWithCounts=$(exercise1 $*)

ipWithCounts=$(sed '/^$/d' <<< "$ipWithCounts")

# For each line of the data from ex1
while read line; do

	# Read the line into an array so that all elements are accessible, but we
	# can opperate on them separately. array[0] = count, array[1] = ip
	read -a array <<< $line

	# Print the count then use ex2 to get the country.
	echo -n ${array[0]}" "
	exercise2 $unquote <<< ${array[1]}
done <<< "$ipWithCounts"
