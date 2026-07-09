package com.example.to_do_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.to_do_api.model.ToDo;
import com.example.to_do_api.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    public ToDo getToDoById(int id) {
        return repository.findById(id).orElse(null);
    }

    public ToDo createToDo(ToDo entity) {
        return repository.save(entity);
    }

    public List<ToDo> getAllToDos() {
        return repository.findAll();
    }

    public void deleteToDoById(int id) {
        repository.deleteById(id);}

    public boolean existsById( int id){
        return repository.existsById(id);
    }
}


