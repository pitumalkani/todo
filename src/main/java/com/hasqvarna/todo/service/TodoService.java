package com.hasqvarna.todo.service;

import com.hasqvarna.todo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final List<Todo> todoList;

    public TodoService(List<Todo> todoList) {
        this.todoList = todoList;
    }


    public Optional<List<Todo>> getAllTodo(){
        return Optional.ofNullable(todoList);
    }

    public Optional<Todo> getTodo(String todoId) {
        return todoList.stream().filter(todo-> todo.getId().toString().equals(todoId)).findAny();
    }

    public Boolean deleteTodo(String todoId) {
        return todoList.removeIf(todo-> todo.getId().toString().equals(todoId));
    }

    public Todo addNewTodo(Todo todo) {
        todoList.add(todo);
        return todo;
    }

    public Optional<List<Todo>> updateTodo(String todoId,Todo todo) {

        System.out.println("TODO-->"+todo);
        if(!todoList.contains(todo)){
            List<Todo> list =
                    todoList.stream()
                            .filter(t-> t.getId().toString().equals(todoId))
                            .map(t-> {
                                t.setDone(todo.isDone());
                                t.setName(todo.getName());
                                return t;
                            })
                            .collect(Collectors.toList());
            return Optional.ofNullable(list);
        }
       return Optional.empty();
    }
}
