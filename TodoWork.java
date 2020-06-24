package com.working.todo.work;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.working.todo.model.TodoList;



@Service
public class TodoWork {
	private Map<Long, TodoList> listMap = new HashMap<>();
	
	public String saveItem(Long id, TodoList description) {
		listMap.put(id, description);
		return "Description is added";
	}

	public TodoList getItem(Long id) {
		return listMap.get(id);
	}
	public Collection<TodoList> getAll(Long id, String description) {
		return listMap.values();
    }
  public TodoList deleteById(Long id) {	
	 return listMap.remove(id);
	  //"Data is deleted";
  }

}
