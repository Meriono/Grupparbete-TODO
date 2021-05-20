package com.example.grupparbetetodo.service;


import com.example.grupparbetetodo.model.Todo;

import com.example.grupparbetetodo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


/**
 * created by Mimi Santana
 * Date: 2021-05-19
 * Time: 16:00
 * Project: Grupparbete-TODO
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    TodoRepository mockRepo;

    TodoService todoService;

    @BeforeEach
    void init(){
        todoService = new TodoService(mockRepo);
    }

    @Test
    void getAll() {
    }

    @Test
    void updateStatus() {
    }

    @Test
    void deleteById() {
        String expectedTodo = "hejsan";
        boolean expectedDone = false;

        Todo deleteTodo = new Todo();
        deleteTodo.setId(1L);
        deleteTodo.setTodo(expectedTodo);
        deleteTodo.setDone(expectedDone);


        mockRepo.deleteById(deleteTodo.getId());

        verify(mockRepo, times(1)).deleteById(deleteTodo.getId());
    }

    @Test
    void addTodo() {
        String expectedTodo = "hejsan";
        boolean expectedDone = false;

        Todo saveTodo = new Todo();
        saveTodo.setTodo(expectedTodo);
        saveTodo.setDone(expectedDone);

        when(mockRepo.save(any())).thenReturn(saveTodo);

        Todo actualTodo = todoService.addTodo(saveTodo);
        assertEquals(saveTodo.getTodo(), actualTodo.getTodo());
    }
}
