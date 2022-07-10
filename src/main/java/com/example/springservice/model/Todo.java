package com.example.springservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("todo")
public class Todo implements Serializable {

    @Id
    private String uid;

    private String content;

    private Date lastTouchedAt;

}
