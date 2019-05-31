package com.test.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.todolist.ToDoListRepository;
import com.test.todolist.beans.Task;

//@RestController
@Controller
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoListRepository toDoListRepository;

	@RequestMapping(value = "/{todo}", method = RequestMethod.GET)
	public String getAllTasks(Model model) {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdTime");
		model.addAttribute("todos", toDoListRepository.findAll(sortByCreatedAtDesc));
		
		return "todoList";
	}

	@RequestMapping(value = "/{todo}", method = RequestMethod.POST)
	public String createTask(Task task) {
		task.setCompleted(false);
		toDoListRepository.save(task);
		System.out.println("Task added:-"+task.getId());
		return "redirect:/{todo}";
	}

	@RequestMapping(value = "/get/{todo}", method = RequestMethod.GET)
	public ResponseEntity<Task> getTodoById(@PathVariable("id") String id) {
		Task todo = toDoListRepository.getOne(id);
		if (todo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		}
	}

	/*
	 * @PutMapping(value = "/todos/{id}") public ResponseEntity<Task>
	 * updateTodo(@PathVariable("id") String id, @Valid @RequestBody Task todo) {
	 * Task todoData = toDoListRepository.getOne(id); if (todoData == null) { return
	 * new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * todoData.setDescription(todo.getDescription());
	 * todoData.setCompleted(todo.isCompleted()); Task updatedTodo =
	 * toDoListRepository.save(todoData); return new ResponseEntity<>(updatedTodo,
	 * HttpStatus.OK); }
	 */
	@DeleteMapping(value = "/todos/del/{id}")
	public String deleteTask(@PathVariable("id") String id) {
		toDoListRepository.deleteById(id);
		return "todoList";
	}
}