#!/bin/bash

# One line version:
#     awk '{print $1}' $1 | sort | uniq -c | sort -nr | head -n10
#
# Arguement on command line is log file to extract ips from
logfile=$1

# ips are all in first column, separated from rest of file by space delimiter
# - cut the first column as delimited by the first space.
# - awk is significantly faster than cut. Prints the first entry, default
#   delimiter is space.
#
#cut -d" " -f1 $logfile | #
awk '{print $1}' $logfile | #

# Sort the list of ips and show only unique entries with a count
sort | uniq --count | #

# Sort again, this time by the count in reverse order
sort --numeric-sort --reverse | #

# Display only the top ten results.
head --lines 10
