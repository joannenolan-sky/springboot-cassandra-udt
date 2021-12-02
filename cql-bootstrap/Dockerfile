FROM cassandra:3.11.4

ADD apply-bootstrap.sh /apply-bootstrap.sh
ADD bootstrap.cql .

ENTRYPOINT ["/apply-bootstrap.sh"]