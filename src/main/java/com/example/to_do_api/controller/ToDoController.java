package com.example.to_do_api.controller;

import com.example.to_do_api.exception.ToDoNotFoundException;
import com.example.to_do_api.service.ToDoService;
import com.example.to_do_api.model.ToDo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Integer id) {
        if(!service.existsById(id)){
            throw new ToDoNotFoundException("Todo not found");
        }
        service.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }

}
