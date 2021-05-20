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

    @GetMapping("/update")
    public String updateStatus(@RequestParam Long todoId, boolean doneStatus) {
        return todoService.updateStatus(todoId,doneStatus);

    }

   @GetMapping("/delete")
    public String deleteById(@RequestParam Long todoId){
       return todoService.deleteById(todoId);
   }

   @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo){
      return todoService.addTodo(todo);
   }

    @GetMapping("/findByDone")
    public Iterable<Todo> getAllByDone(Boolean done) {
        return todoService.findAllByDone(done);
    }
}
