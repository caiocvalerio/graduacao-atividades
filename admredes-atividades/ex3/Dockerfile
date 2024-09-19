FROM ubuntu

RUN apt-get update && \
    apt-get install -y bind9 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY named.conf /etc/bind/
COPY caio.zone /etc/bind/zones/

EXPOSE 53/udp
EXPOSE 53/tcp

CMD ["/usr/sbin/named", "-g"]
