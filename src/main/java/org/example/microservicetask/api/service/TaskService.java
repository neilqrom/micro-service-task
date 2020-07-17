package org.example.microservicetask.api.service;

import java.util.List;

import org.example.microservicetask.domain.entity.Task;

public interface TaskService {

	Task createTask(Task task);
	Task updateTask(Task task) throws Exception;
	List<Task> findAllTask();
}
