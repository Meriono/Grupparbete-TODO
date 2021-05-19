package com.example.grupparbetetodo.controller;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/all")
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    @GetMapping("/update")
    public String updateStatus(@RequestParam Long todoId, boolean doneStatus) {
        todoRepository.findById(todoId).get().setDone(doneStatus);

        return String.format("Todo with id:%s have changed status", todoId);
    }

   // @GetMapping("/delete")

}
