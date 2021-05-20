package com.example.grupparbetetodo.service;

import com.example.grupparbetetodo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    }

    // Get a list of all todos thats done = false aka not done
    @Test
    void findAllByDoneFalse() {
    }
}
