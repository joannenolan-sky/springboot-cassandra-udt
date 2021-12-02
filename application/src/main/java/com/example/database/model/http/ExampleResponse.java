package com.example.database.model.http;

import java.util.Set;

public class ExampleResponse {

    String id;
    String s;
    Set<String> set;

    public ExampleResponse() {  }

    public ExampleResponse(String id, String s, Set<String> set) {
        this.id = id;
        this.s = s;
        this.set = set;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
