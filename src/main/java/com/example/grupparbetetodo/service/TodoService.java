package com.example.grupparbetetodo.service;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by Mimi Santana
 * Date: 2021-05-19
 * Time: 15:49
 * Project: Grupparbete-TODO
 * Copyright: MIT
 */
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;


    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }


    public String updateStatus(@RequestParam Long todoId, boolean doneStatus) {
        todoRepository.findById(todoId).get().setDone(doneStatus);

        return String.format("Todo with id:%s have changed status", todoId);
    }


    public String deleteById(@RequestParam Long todoId){
        todoRepository.deleteById(todoId);
        return String.format("Todo with id:%s is now deleted", todoId);
    }


    public String addTodo(@RequestBody Todo todo){

        todoRepository.save(todo);

        return String.format("%s \nis now added to the list", todo.getTodo());
    }


}
