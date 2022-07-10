package com.example.springservice.controller;

import com.example.springservice.repository.todoRepo;
import com.example.springservice.model.todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springservice.model.Response;

import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/todos")
public class todoController {

    @Autowired
    todoRepo todorepo;

    @GetMapping("/")
    public ResponseEntity<Response> getAllTodos() {
        Response response = new Response();
        response.setData(todorepo.findAll(Sort.by(Sort.Direction.DESC, "lastTouchedAt")));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<Response> createTodo(@RequestBody todo newTodo) {
        Response response = new Response();
        newTodo.setLastTouchedAt(new Date());
        response.setData(todorepo.save(newTodo));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/")
    public ResponseEntity<Response> updateTodo(@RequestBody todo newTodo) {
        Response response = new Response();
        newTodo.setLastTouchedAt(new Date());
        response.setData(todorepo.save(newTodo));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response> updateTodo(@PathVariable UUID uid) {
        todorepo.deleteById(uid);
        return ResponseEntity.ok(new Response());
    }

}
