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

    public void createTask(Todo todo) {
        todo.setCompleted(false);
        iTodoRepository.save(todo);
    }

    public Todo readTask(Integer taskID) {
        Optional<Todo> optionalTodo = iTodoRepository.findById(taskID);
        return optionalTodo.orElse(null);
    }

    public List<Todo> listTask() {
        return iTodoRepository.findAll();
    }

    public void updateTask(Integer taskID, TodoDTO todoDTO) {
        Todo existingTodo = readTask(taskID);
        if (existingTodo != null) {
            existingTodo.setTask(todoDTO.getTask());
            iTodoRepository.save(existingTodo);
        }
    }


    public void deleteTask(Integer taskID) {
        iTodoRepository.deleteById(taskID);
    }

    public void deleteAllTasks() {
        iTodoRepository.deleteAll();
    }
}








