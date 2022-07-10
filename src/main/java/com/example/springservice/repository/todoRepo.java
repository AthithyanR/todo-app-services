package com.example.springservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springservice.model.todo;

import java.util.UUID;

@Repository
public interface todoRepo extends JpaRepository<todo, UUID> {
}
