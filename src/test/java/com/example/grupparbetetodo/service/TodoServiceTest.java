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
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

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
        long todoId = 1L;
        Todo dishes = new Todo(todoId,"Do the dishes",false);

        when(mockRepo.getTodoById(todoId)).thenReturn(dishes);
        when(todoService.getAll()).thenReturn(List.of(dishes));

        todoService.updateStatus(dishes.getId(),true);
        List<Todo> actual = (List<Todo>) todoService.getAll();
        Todo updatedDishes = actual.get(0);

        assertTrue(updatedDishes.isDone());
        assertEquals(todoId, updatedDishes.getId());
    }

    @Test
    void deleteById() {
        String expectedTodo = "Ta bort denna";
        boolean expectedDone = false;

        Todo deleteTodo = new Todo();
        deleteTodo.setId(1L);
        deleteTodo.setTodo(expectedTodo);
        deleteTodo.setDone(expectedDone);

        when(mockRepo.save(deleteTodo)).thenReturn(deleteTodo);

        Todo actualTodo = todoService.addTodo(deleteTodo);
        assertEquals(deleteTodo.getTodo(), actualTodo.getTodo());

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

        when(mockRepo.save(saveTodo)).thenReturn(saveTodo);

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

    @Test
    void updateTodoTest(){
        long todoId = 1L;
        Todo dishes = new Todo(todoId,"Do the dishes",false);
        Todo newDishes = new Todo(todoId,"clean dishes",true);

        when(mockRepo.getTodoById(todoId)).thenReturn(dishes);
        when(todoService.getAll()).thenReturn(List.of(dishes));

        todoService.updateTodo(newDishes);
        List<Todo> actual = (List<Todo>) todoService.getAll();
        Todo updatedDishes = actual.get(0);

        assertEquals(dishes.getTodo(),updatedDishes.getTodo());

    }

    @Test
    void wrongInputOnUpdateTest(){
        Todo falseTodo = new Todo(7L,"wash black clothing",false);
        assertThrows(NullPointerException.class, () -> todoService.updateTodo(falseTodo));
    }

    @Test
    void findTodobyIdThrows(){

        assertThrows(NoSuchElementException.class, ()-> todoService.findById(5L));
    }


}
