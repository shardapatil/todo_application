package com.todoapp.pojo;

public class TodoData {
	private int todoid;
	private String description;
	private String date;
	
	public int getTodoid() {
		return todoid;
	}
	public void setTodoid(int todoid) {
		this.todoid = todoid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		
		return todoid + " " + description + " " + date;
	}
}
