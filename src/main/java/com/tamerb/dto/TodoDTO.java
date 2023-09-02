package com.tamerb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoDTO {

    // ID
    @NotBlank(message = "ID cannot be empty")
    private Integer id;

    // Task
    @NotBlank(message = "Task cannot be empty")
    String task;

    // Completed
    @NotBlank(message = "Completed cannot be empty")
    Boolean completed;

}
