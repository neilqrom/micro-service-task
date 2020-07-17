package org.example.microservicetask.api.controllers;

import org.example.microservicetask.api.service.TaskService;
import org.example.microservicetask.domain.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(value = "Gestion de tareas", consumes = "application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
@RestController
@Slf4j
public class TaskController {
	
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping("/tasks")
	public ResponseEntity<Object> findAllTask() {
    	log.debug("into findAllTask()");
        return new ResponseEntity<>(this.taskService.findAllTask(), HttpStatus.OK);
    }
    
    @PostMapping("/task")
	public ResponseEntity<Object> createTask(@RequestBody @Validated Task task) {
    	log.debug("into createTask(task)");
        return new ResponseEntity<>(this.taskService.createTask(task), HttpStatus.CREATED);
    }
    
    @PutMapping("/task")
	public ResponseEntity<Object> updateTask(@RequestBody @Validated Task task) throws Exception {
    	log.debug("into updateTask(task)");
    	return new ResponseEntity<>(this.taskService.updateTask(task), HttpStatus.OK);
    }
}
