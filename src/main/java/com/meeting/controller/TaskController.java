package com.meeting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.Meeting;
import com.meeting.model.Task;
import com.meeting.repository.MeetingRepository;
import com.meeting.repository.TaskRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private MeetingRepository meetingRepository;
	
	@GetMapping("/tasks/{meetingId}")
	public List<Task> getTasksByMeetingId(@PathVariable("meetingId") 
	int meetingId){
		//go to repo and fetch all tasks based on meeting id
		return taskRepository.findAllByMeetingId(meetingId);
	}
	@GetMapping("/tasks")
	public List<Task> getAllTasks(){
		//go to repo and fetch all tasks based on meeting id
		return taskRepository.findAll();
	}
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable("id") int taskId){
		return taskRepository.getOne(taskId);
	}
	
	@PostMapping("/task")
	public Task addTask(@RequestBody Task task){
		return taskRepository.save(task);
	}
	
	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable("id") int id){
		taskRepository.deleteById(id);
	}
	@PutMapping("/task/{id}")
	public Task editTask(@PathVariable("id") int id,@RequestBody 
			Task task){ //new task value
		//get existing task out from DB
		Task t1 = taskRepository.getOne(id);//existing
		t1.setDetails(task.getDetails());
		
		//save t1 in DB
		return taskRepository.save(t1);
	}
	
}








