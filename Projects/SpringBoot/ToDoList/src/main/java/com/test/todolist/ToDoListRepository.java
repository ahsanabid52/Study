package com.test.todolist;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.todolist.beans.Task;

public interface ToDoListRepository extends JpaRepository<Task, String> {

}