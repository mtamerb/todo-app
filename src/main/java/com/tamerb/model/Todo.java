package com.tamerb.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity()
@Table(name = "todo")
public class Todo implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Task
    @NotBlank(message = "Task cannot be empty")
    @Column(name = "task")
    private String task;

    // Completed
    @Column(name = "is_completed")
    private Boolean completed ;

    // System Date
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public Todo() {
    }

    public Todo(Integer id, String task, Boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }


}
