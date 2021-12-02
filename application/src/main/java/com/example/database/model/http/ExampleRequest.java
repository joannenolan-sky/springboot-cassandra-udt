package com.example.database.model.http;

import java.util.Set;

public class ExampleRequest {

    String id;
    String name;
    Set<String> data;

    public ExampleRequest(String id, String name, Set<String> data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public ExampleRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }

    public Set<String> getData() {
        return data;
    }

}
