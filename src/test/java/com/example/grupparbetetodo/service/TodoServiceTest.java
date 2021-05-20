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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

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
        String expectedTodo = "hejsan";
        boolean expectedDone = false;

        Todo saveTodo = new Todo();
        saveTodo.setTodo(expectedTodo);
        saveTodo.setDone(expectedDone);

        when(mockRepo.save(any())).thenReturn(saveTodo);

        Todo actualTodo = todoService.addTodo(saveTodo);
        assertEquals(saveTodo.getTodo(), actualTodo.getTodo());
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
