package com.tamerb.controller;

import com.tamerb.assist.FrontEnd;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo/api/")
@CrossOrigin(origins = FrontEnd.REACT_URL) // http://localhost:3000
public class TodoController {


}
