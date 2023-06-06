package com.todoapp.dao;

import java.util.List;

import com.todoapp.pojo.TodoData;

public interface TodoDoa {
	
	List<TodoData> viewTodo();
	
	boolean createTodo(TodoData todo);
	boolean updateTodo(TodoData todo);
	boolean delTodo(int id);
	
}
