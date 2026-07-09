package com.example.to_do_api.controller;

import com.example.to_do_api.service.ToDoService;
import com.example.to_do_api.model.ToDo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class ToDoController {

    private final ToDoService service;

    @GetMapping("/getById")
    public ResponseEntity<ToDo> getById(@RequestParam int id) {
        return ResponseEntity.ok(service.getToDoById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<ToDo>> getAllToDos() {
        return ResponseEntity.ok((ArrayList<ToDo>) service.getAllToDos());
    }

    @PostMapping()
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo entity) {
        return ResponseEntity.ok(service.createToDo(entity));
    }

}
