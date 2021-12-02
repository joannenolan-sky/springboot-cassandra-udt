package com.example.database.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Objects;
import java.util.Set;

@UserDefinedType("info")
public class Info {

    @Column("field1")
    private String field1;

    @Column("fieldSet")
    private Set<String> fieldSet;

    public Info() {
    }
    public Info(
            String field1, Set<String> fieldSet) {
        this.field1 = field1;
        this.fieldSet = fieldSet;
    }

    public String getField1() {
        return field1;
    }

    public Info setField1(String field1) {
        this.field1 = field1;
        return this;
    }

    public Set<String> getFieldSet() {
        return fieldSet;
    }

    public Info setFieldSet(Set<String> fieldSet) {
        this.fieldSet = fieldSet;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(field1, info.field1) && Objects.equals(fieldSet, info.fieldSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, fieldSet);
    }

    @Override
    public String toString() {
        return "Info{" +
                "field1='" + field1 + '\'' +
                ", fieldSet=" + fieldSet +
                '}';
    }
}
