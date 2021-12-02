#!/usr/bin/env bash

create_keyspace() {
  cqlsh "cassandra" -f bootstrap.cql
  result=$?

  return $result
}

main() {
    if create_keyspace ; then
      echo ""
      echo "> Schema created"
      return 0
    else
      echo ""
      echo "> Schema creation failed"
    fi
  return 1
}

main
result=$?
exit $result