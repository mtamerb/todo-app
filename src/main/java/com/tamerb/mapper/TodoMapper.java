package com.tamerb.mapper;

import com.tamerb.dto.TodoDto;
import com.tamerb.model.Todo;

public class TodoMapper {


    public static TodoDto mapToTodoDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getTask(), todo.getCompleted());
    }

    public static Todo mapToTodo(TodoDto todoDto){
        return new Todo(todoDto.getId(), todoDto.getTask(), todoDto.getCompleted());
    }


}
