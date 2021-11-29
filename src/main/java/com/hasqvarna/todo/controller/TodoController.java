package com.hasqvarna.todo.controller;

import com.hasqvarna.todo.domain.Todo;
import com.hasqvarna.todo.service.TodoService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo( @Valid @RequestBody Todo todo){
        return ResponseEntity.ok().body( todoService.addNewTodo(todo));
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable String todoId){
        Optional<Todo> todo = todoService.getTodo(todoId);
        return todo.isPresent()
                ? ResponseEntity.ok(todo.get())
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        Optional<List<Todo>> todoList = todoService.getAllTodo();
        return todoList.isPresent()? ResponseEntity.ok(todoList.get()): ResponseEntity.noContent().build();
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String todoId,@RequestBody  Todo todo){
        Optional<List<Todo>> updatedTodo = todoService.updateTodo(todoId,todo);
        return updatedTodo.isPresent()? ResponseEntity.ok(updatedTodo.get().get(0)) : ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable String todoId)
    {
        Boolean isDeleted = todoService.deleteTodo(todoId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
