package com.example.grupparbetetodo.controller;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

   @GetMapping("/delete")
    public String deleteById(@RequestParam Long todoId){
        todoRepository.deleteById(todoId);
       return String.format("Todo with id:%s is now deleted", todoId);
   }

   @PostMapping("/add")
    public String addTodo(@RequestBody Todo todo){

        todoRepository.save(todo);

        return String.format("%s \nis now added to the list", todo.getTodo());
   }

}
