package com.example.springservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.example.springservice.model.Todo;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class todoRepo {
    public static final String HASH_KEY = "todo";

    @Autowired
    private RedisTemplate template;

    public Todo save(Todo todo){
        if (Objects.isNull(todo.getUid())) {
            todo.setUid(UUID.randomUUID().toString());
        }
        template.opsForHash().put(HASH_KEY,todo.getUid(),todo);
        return todo;
    }

    public List<Todo> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public void deleteById(String uid){
        template.opsForHash().delete(HASH_KEY, uid);
    }

}
