CREATE KEYSPACE IF NOT EXISTS example WITH replication = {'class': 'SimpleStrategy','replication_factor': 1};

CREATE TYPE IF NOT EXISTS example.info (fieldSet set<text>, field1 text);

CREATE TABLE IF NOT EXISTS example.table1 (info set<frozen<info>>, field2 text, PRIMARY KEY (field2));