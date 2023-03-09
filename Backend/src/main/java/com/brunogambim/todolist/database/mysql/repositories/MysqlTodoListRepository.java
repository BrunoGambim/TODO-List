package com.brunogambim.todolist.database.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunogambim.todolist.database.mysql.models.TodoListModel;

@Repository
public interface MysqlTodoListRepository extends JpaRepository<TodoListModel, Long> {

}
