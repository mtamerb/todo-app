package com.tamerb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoDTO {

    @NotBlank(message = "ID cannot be empty")
    private Integer id;

    @NotBlank(message = "Task cannot be empty")
    String task;


}
