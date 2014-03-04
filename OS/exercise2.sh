#!/bin/bash

## Simple version

# while read ip; do
# 	curl -s http://freegeoip.net/csv/"$ip" | awk -F "," '{print$1 "," $2}'
# done

usage="$(basename "$0") [-hu]
Prints the estimated country code of the given
ip address using the service at freegeoip.net.

Reads from stdin, new line separated list of
ip addresses, or, when invoked without any data,
allows the user to enter ip's manually. Press
CTRL-D to exit.

where:
	-h  show this help text
	-u  return the data without quotes."

unquote=false

OPTIND=1

# Process commandline argument flags
while getopts "uh" opt ; do
	case $opt in
		h)
		echo "$usage"
		exit 1 ;;
		u)
		unquote=true ;;
	esac
done

# Read in ip addresses until "read" returns false, ie end of input
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
	specData=$(echo "$data" | awk -F "," '{print $1 "," $2}')

	# if the option to unquote the final text was given, delete all quote
	# characters from the string.
	if $unquote ; then
		specData=$(echo "$specData" | tr -d "\"")
	fi

	# Print the final data, should be of the form
	# xxx.xxx.xxx.xxx,AA      or
	# "xxx.xxx.xxx.xxx","AA"
	echo "$specData"
done
