package com.tamerb.controller;

import com.tamerb.assist.FrontEnd;
import com.tamerb.dto.TodoDTO;
import com.tamerb.model.Todo;
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

    @PostMapping("create")
    public ResponseEntity<List<Todo>> createTask(@Valid @RequestBody TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTask(todoDTO.getTask());
        todo.setCompleted(false);
        todoService.createTask(todo);
        List<Todo> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Todo>> listTasks() {
        List<Todo> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PutMapping("update/{taskID}")
    public ResponseEntity<List<Todo>> updateTask(@PathVariable Integer taskID, @Valid @RequestBody TodoDTO todoDTO) {
        Todo todo = todoService.readTask(taskID);
        if (Objects.isNull(todo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todo.setTask(todoDTO.getTask());
        todoService.updateTask(taskID, todoDTO);
        return new ResponseEntity<>(todoService.listTask(), HttpStatus.OK);
    }

    @PutMapping("update/check/{taskID}/{completed}")
    public ResponseEntity<List<Todo>> updateTask(@PathVariable Integer taskID, @PathVariable Boolean completed) {

        Todo todo = todoService.readTask(taskID);
        if (Objects.isNull(todo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todo.setCompleted(completed);
        todoService.updateCheckStatus(taskID, completed);
        return new ResponseEntity<>(todoService.listTask(), HttpStatus.OK);

    }

    @DeleteMapping("delete/{taskID}")
    public ResponseEntity<List<Todo>> deleteTask(@PathVariable Integer taskID) {
        Todo todo = todoService.readTask(taskID);
        if (Objects.isNull(todo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todoService.deleteTask(taskID);
        List<Todo> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<List<Todo>> deleteAllTasks() {
        todoService.deleteAllTasks();
        List<Todo> todos = todoService.listTask();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}