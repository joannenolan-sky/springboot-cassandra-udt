## Overview

### Cassandra user defined data type (UDT):

User-defined types (UDTs) can create Cassandra data models to allow for easier storage and parsing of detailed data with a named column. 
he fields can be made up of any support type

### How to run

Runs as a docker compose example, with :
- Cassandra instance
- a bootstrap creator for the tables and keyspaces 
- the Springboot Application

### What the example contains

- Cassandra Bootstrap
A Cassandra bootstrap command to create the keyspace and table in Cassandra so they are present when the Springboot Application starts up. 
This is standalone only requires the cql files that need to be applied.

- Springboot Application
This application contains a basic Springboot Application that uses `org.springframework.boot:spring-boot-starter-data-cassandra` to use the table within the applicaiotn. This gives us annotations such as :
  - @Repository which exposes some basic lookups immediately. Explained in more detail - https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#repositories.core-concepts

- example.http 
This contains some http examples that will add, remove or get data in Cassandra

