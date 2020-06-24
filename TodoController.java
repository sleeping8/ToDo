package com.working.todo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.working.todo.model.TodoList;
import com.working.todo.work.TodoWork;

@RestController
public class TodoController {

	//@CrossOrigin(origins="*")
		
		@Autowired
		TodoWork TodoWorkService;
		
		@Bean
		public WebMvcConfigurer configure() {
			return new WebMvcConfigurer() {
	           @Override
				public void addCorsMappings(CorsRegistry registry) {
				   registry.addMapping("/*").allowedOrigins("*");
				}
			};
		}


	  @GetMapping("/health")
		public String health() {
		// ListWorkService.saveItem((long) 24,"to go shopping", null); 
			return "App is up and running...!!!";
		}
	  @PostMapping(path="/items/{id}", consumes= "application/json", produces= "application/json")
	  public String addDescription( @RequestBody  TodoList description, @PathVariable Long id) {
		return TodoWorkService.saveItem(id, description);
	  }
	  @GetMapping(value="/items/{id}", consumes="application/json", produces="application/json")
	  public TodoList getDescription(@PathVariable Long id) {
		  return TodoWorkService.getItem(id);
	  }
	  @GetMapping(value="/test",consumes="application/json", produces="application/json")
	  public Collection<TodoList> All( Long id ,String description) {
		return  TodoWorkService.getAll(id, description); 
	  }
	  
	  @PutMapping(value="/items/{id}", consumes="application/json", produces="application/json")
	  public String updateDescription(@RequestBody TodoList description,@PathVariable  Long id) {
		 return TodoWorkService.saveItem(id, description);
	  }
	  @DeleteMapping(value="/{id}")
	  public TodoList deleteDescription(@PathVariable Long id) {
		 return TodoWorkService.deleteById(id);
		 }
	  
}
