FROM ubuntu:latest
RUN ln -fs /usr/share/zoneinfo/America/Cuiaba /etc/localtime
RUN apt-get update && apt-get install -y ntp
EXPOSE 123/udp
CMD ["ntpd", "-n", "-u", "ntp:ntp", "-p", "/var/run/ntpd.pid", "-g", "-4"]
