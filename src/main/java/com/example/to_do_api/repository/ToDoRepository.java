package com.example.to_do_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.to_do_api.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
