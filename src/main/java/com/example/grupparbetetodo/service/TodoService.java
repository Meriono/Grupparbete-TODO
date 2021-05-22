package com.example.grupparbetetodo.service;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;


    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }


    public String updateStatus(Long todoId, boolean doneStatus) {

        Todo todo = todoRepository.getTodoById(todoId);
        todo.setDone(doneStatus);
        todoRepository.save(todo);

        return String.format("Todo with id:%s have changed status", todoId);
    }


    public String deleteById(Long todoId){
        todoRepository.deleteById(todoId);
        return String.format("Todo with id:%s is now deleted", todoId);
    }


    public Todo addTodo(Todo todo){

        return todoRepository.save(todo);
    }

    public Iterable<Todo> findAllByDone(boolean done){
        return todoRepository.findAllByDone(done);
    }

    public Todo updateTodoText(Long id, String text){
      Todo updateTodo = todoRepository.getTodoById(id);
      updateTodo.setTodo(text);
      todoRepository.save(updateTodo);

      return updateTodo;
    }

    public Todo findById(Long todoId){
        return todoRepository.findById(todoId).get();
    }

}
