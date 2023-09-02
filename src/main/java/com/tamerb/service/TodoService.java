package com.tamerb.service;

import com.tamerb.dto.TodoDTO;
import com.tamerb.model.Todo;
import com.tamerb.repository.ITodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TodoService {

    private final ITodoRepository iTodoRepository;

    // CREATE TASK SERVICE
    public void createTask(Todo todo) {
        todo.setCompleted(false);
        iTodoRepository.save(todo);
    }

    // READ TASK SERVICE
    public Todo readTask(Integer taskID) {
        Optional<Todo> optionalTodo = iTodoRepository.findById(taskID);
        return optionalTodo.orElse(null);
    }

    // LIST TASK SERVICE
    public List<Todo> listTask() {
        return iTodoRepository.findAll();
    }

    // UPDATE TASK SERVICE
    public void updateTask(Integer taskID, TodoDTO todoDTO) {
        Todo existingTodo = readTask(taskID);
        if (existingTodo != null) {
            existingTodo.setTask(todoDTO.getTask());
            iTodoRepository.save(existingTodo);
        }
    }

    // UPDATE CHECK STATUS SERVICE
    public void updateCheckStatus(Integer taskID, Boolean completed) {
        Todo existingTodo = readTask(taskID);
        if (existingTodo != null) {
            existingTodo.setCompleted(completed);
            iTodoRepository.save(existingTodo);
        }
    }

    // UPDATE CHECK STATUS SERVICE
    public void deleteTask(Integer taskID) {
        iTodoRepository.deleteById(taskID);
    }

    // DELETE ALL TASKS SERVICE
    public void deleteAllTasks() {
        iTodoRepository.deleteAll();
    }
}








