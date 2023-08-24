package com.tamerb.repository;

import com.tamerb.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<Todo,Integer> {

}
