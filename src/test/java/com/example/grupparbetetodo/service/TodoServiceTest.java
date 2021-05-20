package com.example.grupparbetetodo.service;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
    }

    @Test
    void addTodo() {
    }

    // Get a list of all todos thats done = true
    @Test
    void findAllByDoneTrue() {
        Todo expected = new Todo(1L, "feed the cat", true);

        when(mockRepo.findAllByDone(true)).thenReturn(Arrays.asList(expected));
        List<Todo> actual = (List<Todo>) todoService.findAllByDone(true);

        verify(mockRepo).findAllByDone(true);
        assertEquals(mockRepo.findAllByDone(true), actual);
    }

    // Get a list of all todos thats done = false aka not done
    @Test
    void findAllByDoneFalse() {
        Todo expected = new Todo(1L, "clean up", false);

        when(mockRepo.findAllByDone(false)).thenReturn(Arrays.asList(expected));
        List<Todo> actual = (List<Todo>) todoService.findAllByDone(false);

        verify(mockRepo).findAllByDone(false);
        assertEquals(mockRepo.findAllByDone(false), actual);
    }
}
