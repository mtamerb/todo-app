package com.tamerb.controller;

import com.tamerb.assist.FrontEnd;
import com.tamerb.dto.TodoDto;
import com.tamerb.service.TodoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
@CrossOrigin(origins = FrontEnd.REACT_URL) // http://localhost:3000
public class TodoController {

    private final TodoService todoService;


    // localhost:8080/api/create
    @PostMapping("create")
    public ResponseEntity<List<TodoDto>> createTask(@Valid @RequestBody TodoDto todoDto) {
        todoDto.setTask(todoDto.getTask());
        todoDto.setCompleted(false);
        todoService.createTask(todoDto);
        List<TodoDto> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // localhost:8080/api/list
    @GetMapping("/list")
    public ResponseEntity<List<TodoDto>> listTasks() {
        List<TodoDto> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // localhost:8080/api/update/{taskID}
    @PutMapping("update/{taskID}")
    public ResponseEntity<List<TodoDto>> updateTask(@PathVariable Integer taskID, @Valid @RequestBody TodoDto todoDTO) {
        TodoDto todo = todoService.readTask(taskID);
        if (Objects.isNull(todo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todo.setTask(todoDTO.getTask());
        todoService.updateTask(taskID, todoDTO);
        return new ResponseEntity<>(todoService.listTask(), HttpStatus.OK);
    }

    // localhost:8080/api/update/check/{taskID}/{completed}
    @PutMapping("update/check/{taskID}/{completed}")
    public ResponseEntity<List<TodoDto>> updateTask(@PathVariable Integer taskID, @PathVariable Boolean completed) {

        TodoDto todo = todoService.readTask(taskID);
        if (Objects.isNull(todo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todo.setCompleted(completed);
        todoService.updateCheckStatus(taskID, completed);
        return new ResponseEntity<>(todoService.listTask(), HttpStatus.OK);

    }

    // localhost:8080/api/delete/{taskID}
    @DeleteMapping("delete/{taskID}")
    public ResponseEntity<List<TodoDto>> deleteTask(@PathVariable Integer taskID) {
        TodoDto todo = todoService.readTask(taskID);
        if (Objects.isNull(todo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todoService.deleteTask(taskID);
        List<TodoDto> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // localhost:8080/api/deleteAll
    @DeleteMapping("deleteAll")
    public ResponseEntity<List<TodoDto>> deleteAllTasks() {
        todoService.deleteAllTasks();
        List<TodoDto> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}