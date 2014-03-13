#!/bin/bash

usage="$(basename "$0") [-hu] [log file]
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

#### Start script ####

# Use ex1 to get ips with counts from file
ipWithCounts=$(./exercise1.sh $1)

# For each line of the data from ex1
while read line; do

	# Read the line into an array so that all elements are accessible, but we
	# can opperate on them separately. array[0] = count, array[1] = ip
	read -a array <<< $line

	# Print the count then use ex2 to get the country.
	echo -n ${array[0]}" "
	./exercise2.sh $2 <<< ${array[1]}
done <<< "$ipWithCounts"
