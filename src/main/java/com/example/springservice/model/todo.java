package com.example.springservice.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "todo")
public class todo implements Serializable {

    @Id
    @Column(name = "uid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uid;

    @Column(name = "content")
    private String content;

    @Column(name="last_touched_at")
    private Date lastTouchedAt;

}
