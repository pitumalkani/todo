
package com.hasqvarna.todo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hasqvarna.todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TodoApplication.class)
public class TodoApplicationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;


	@Test
	public void shouldCreateNewTodo()  {
		Todo todo = new Todo("Testing for new todo");
		ResponseEntity<String> response = restTemplate.postForEntity("/todo", todo, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldThrowBadRequestForEmptyName()  {
		Todo todo = new Todo(null);
		ResponseEntity<String> response = restTemplate.postForEntity("/todo", todo, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

	@Test
	public void shouldGetAllTodo()  {
		Todo todo = new Todo("Testing for new todo");
		ResponseEntity<String> response = restTemplate.getForEntity("/todo",String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldGiveNotFoundForGetTodoById()  {
		Todo todo = new Todo("Testing for new todo");
		ResponseEntity<String> response = restTemplate.getForEntity("/todo/f9266b9a-327f-475e-af7b-97cd3fe9ad99",String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void shouldDeleteById(){
		Todo todo = new Todo("Testing for new todo");
		ResponseEntity<Todo> response = restTemplate.postForEntity("/todo", todo, Todo.class);
		HttpEntity<Todo> entity = new HttpEntity<Todo>(todo);
		ResponseEntity<Todo> responseMS  = restTemplate.exchange("/todo/"+response.getBody().getId(), HttpMethod.DELETE, entity, Todo.class);
		assertThat(responseMS.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
		responseMS  = restTemplate.exchange("/todo/"+response.getBody().getId(), HttpMethod.DELETE, entity, Todo.class);
		assertThat(responseMS.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}

