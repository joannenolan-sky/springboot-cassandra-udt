package com.example.database.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.Set;

@Table("table1")
public class Table1 {

    @PrimaryKey
    private String field2;

    @Column("info")
    private Set<@Frozen Info> info;

    public Table1(String field2, Set<@Frozen Info> info) {
        this.field2 = field2;
        this.info = info;
    }

    public String getField2() {
        return field2;
    }

    public Table1 setField2(String field2) {
        this.field2 = field2;
        return this;
    }

    public Set<Info> getInfo() {
        return info;
    }

    public Table1 setInfo(Set<Info> info) {
        this.info = info;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table1 table1 = (Table1) o;
        return Objects.equals(field2, table1.field2) && Objects.equals(info, table1.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field2, info);
    }

    @Override
    public String toString() {
        return "Table1{" +
                "field2='" + field2 + '\'' +
                ", info=" + info +
                '}';
    }
}
