package com.hasqvarna.todo.service;

import com.hasqvarna.todo.domain.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TodoServiceTest {

    private TodoService todoService;

    private List<Todo> todoList;

    @BeforeEach
    public void setUp() {
        todoList = new ArrayList<>();
        todoList.add(new Todo("Buy new book"));
        todoList.add(new Todo("Buy new cycle"));
        todoList.add(new Todo("Buy new tennis bat"));
        todoList.add(new Todo("Buy new camera"));
        todoService = new TodoService(todoList);
    }

    @Test
    public void testGetAllTodo() {
        todoService.getAllTodo();
        assertThat(todoService.getAllTodo().get().size()).isEqualTo(4);
    }

    @Test
    public void givenAddTodoThatExistsShouldReturnTodoList() {
        todoService.addNewTodo(new Todo("Testing unit test todo"));
        assertThat(todoService.getAllTodo().get().size()).isEqualTo(5);
    }

    @Test
    public void givenTodoIdThatDoesNotExistShouldReturnNull() {
        assertThat(todoService.getTodo("unknown-id")).isEqualTo(Optional.empty());
    }

    @Test
    public void givenTodoIdThatDoesNotExistForDeleteShouldReturnFalse() {
        assertThat(todoService.deleteTodo("unknown-id")).isFalse();
    }

    @Test
    public void givenTodoIdThatExistForDeleteShouldReturnTrue() {
        assertThat(todoService.deleteTodo(todoList.get(0).getId().toString())).isTrue();
    }

    @Test
    public void givenTodoIdThatExistToUpdateShouldReturnUpdatedEntity() {
        Todo todo = new Todo("Buy new book");
        todo.setDone(true);
        assertThat(todoService.updateTodo(todoList.get(0).getId().toString(), todo)).isPresent().get().isNotNull();
    }


}
