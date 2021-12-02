package com.example.database.service;

import com.example.database.model.Info;
import com.example.database.model.http.ExampleRequest;
import com.example.database.repository.Table1Repository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CassandraService {

    private final Table1Repository table1Repository;

    public CassandraService(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }


    public void update(ExampleRequest request) {
        Info info = new Info(request.getName(), request.getData());
        table1Repository.addRecord(request.getId(), Set.of(info));
    }

    public void remove(ExampleRequest request) {
        Info info = new Info(request.getName(), request.getData());
        table1Repository.deleteRecord(request.getId(), Set.of(info));
    }

    public String get(String id) {
        return table1Repository.findById(id).orElseGet(null).toString();
    }
}
