package com.tamerb.service;


import com.tamerb.repository.ITodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoService {

    private final ITodoRepository iTodoRepository;

}
