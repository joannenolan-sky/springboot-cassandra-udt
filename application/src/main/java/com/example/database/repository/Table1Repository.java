package com.example.database.repository;

import com.example.database.model.Info;
import com.example.database.model.Table1;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface Table1Repository extends CassandraRepository<Table1, String> {

    @Query("UPDATE table1 SET info = info + :info WHERE field2 = :field2")
    void addRecord(String field2, Set<Info> info);

    @Query("UPDATE table1 SET info = info - :info WHERE field2 = :field2")
    void deleteRecord(String field2, Set<Info> info);
}
