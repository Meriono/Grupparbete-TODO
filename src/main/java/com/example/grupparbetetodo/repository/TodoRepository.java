package com.example.grupparbetetodo.repository;

import com.example.grupparbetetodo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    Iterable<Todo> findAllByDone(boolean done);

    Todo getTodoById (Long aLong);
}
