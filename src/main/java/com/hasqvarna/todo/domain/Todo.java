package com.hasqvarna.todo.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Todo {

    private  UUID id ;

    @NotNull
    private  String name;

    private  Date createdDate;

    private  boolean isDone;

    public Todo(String name) {
        this.name = name;
        this.createdDate = new Date();
        this.id = UUID.randomUUID();
    }

    public Todo() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", isDone=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return isDone == todo.isDone && Objects.equals(name, todo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdDate, isDone);
    }
}
