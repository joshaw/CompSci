read ip

#if $ip not matches ip regex
echo "Input is not a valid ip address" >&2
exit 1

data=$(curl -s http://freegeoip.net/csv/$ip)

echo $data | awk -F "," '{print $1 " " $2}'
