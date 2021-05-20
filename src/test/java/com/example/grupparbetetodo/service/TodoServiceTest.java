package com.example.grupparbetetodo.service;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

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
        Todo dishes = new Todo(1L,"Do the dishes",true);
        Todo garbage = new Todo(2L,"Take out the stinky garbage",false);
        Todo laundry = new Todo(3L,"Do the laundry",true);
        Todo cookDinner = new Todo(4L,"Cook delicious dinner",false);

        when(mockRepo.findAll()).thenReturn(Arrays.asList(dishes, garbage, laundry, cookDinner));
        List<Todo> actual = (List<Todo>) todoService.getAll();

        assertEquals(4, actual.size());
        assertNotEquals(5, actual.size());
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
}
