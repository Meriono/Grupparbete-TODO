package com.example.grupparbetetodo.controller;

import com.example.grupparbetetodo.model.Todo;
import com.example.grupparbetetodo.repository.TodoRepository;
import com.example.grupparbetetodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/todo")
public class TodoController {

    private final TodoService todoService;


    @GetMapping("/all")
    public Iterable<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/update/{id}/{doneStatus}")
    public String updateStatus(@PathVariable Long id, @PathVariable boolean doneStatus) {
        return todoService.updateStatus(id, doneStatus);

    }

   @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
       return todoService.deleteById(id);
   }

   @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo){
      return todoService.addTodo(todo);
   }

    @GetMapping("/findByDone/{doneStatus}")
    public Iterable<Todo> getAllByDone(@PathVariable boolean doneStatus) {
        return todoService.findAllByDone(doneStatus);
    }

    @PostMapping("/update")
    public Todo updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }
}
