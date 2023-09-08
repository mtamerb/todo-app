package com.tamerb.service.impl;

import com.tamerb.mapper.TodoMapper;
import com.tamerb.dto.TodoDto;
import com.tamerb.model.Todo;
import com.tamerb.repository.ITodoRepository;
import com.tamerb.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {


    private final ITodoRepository iTodoRepository;


    @Override
    public void createTask(TodoDto todoDto) {
        Todo todo = TodoMapper.mapToTodo(todoDto);
        todo.setCompleted(false);
        iTodoRepository.save(todo);
    }


    @Override
    public TodoDto readTask(Integer taskID) {
        Optional<Todo> optionalTodo = iTodoRepository.findById(taskID);
        return optionalTodo.map(TodoMapper::mapToTodoDto).orElse(null);
    }

    @Override
    public List<TodoDto> listTask() {
        return iTodoRepository
                .findAll()
                    .stream()
                        .map(TodoMapper::mapToTodoDto)
                            .toList();
    }

    @Override
    public void updateTask(Integer taskID, TodoDto todoDTO) {
        TodoDto existingTodo = readTask(taskID);
        if (existingTodo != null) {
            existingTodo.setTask(todoDTO.getTask());
            iTodoRepository.save(TodoMapper.mapToTodo(existingTodo));
        }
    }

    @Override
    public void updateCheckStatus(Integer taskID, Boolean completed) {
        TodoDto existingTodo = readTask(taskID);
        if (existingTodo != null) {
            existingTodo.setCompleted(completed);
            iTodoRepository.save(TodoMapper.mapToTodo(existingTodo));
        }
    }

    @Override
    public void deleteTask(Integer taskID) {
        iTodoRepository.deleteById(taskID);
    }

    @Override
    public void deleteAllTasks() {
        iTodoRepository.deleteAll();
    }
}
