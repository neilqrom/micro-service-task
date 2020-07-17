package org.example.microservicetask.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.example.microservicetask.api.exception.BussinessException;
import org.example.microservicetask.api.service.TaskService;
import org.example.microservicetask.domain.entity.Task;
import org.example.microservicetask.domain.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{
	
	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Override
	public Task createTask(Task task) {
		log.debug("into createTask(task)");
		if(task.getStatus().getId() == null) {
			task.setStatus(null);
		}
		if(task.getPerson().getId() == null) {
			task.setPerson(null);
		}
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		log.debug("into updateTask(task)");
		if(taskRepository.findById(task.getId()).isPresent()) {
			if(task.getStatus().getId() == null) {
				task.setStatus(null);
			}
			if(task.getPerson().getId() == null) {
				task.setPerson(null);
			}
			return taskRepository.save(task);
		}
		throw new BussinessException(HttpStatus.NOT_FOUND);
	}

	@Override
	public List<Task> findAllTask() {
		log.debug("into findAllTask()");
		return taskRepository.findAll()
				.stream()
				.filter(predicate -> predicate.getActive())
				.collect(Collectors.toList());
	}

}
