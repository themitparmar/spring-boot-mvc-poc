package com.poc.service;

import com.poc.exception.TaskServiceException;
import com.poc.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> searchTasks() throws TaskServiceException;

    public Task searchTaskById(Long taskId) throws TaskServiceException;

    public Task createOrUpdateTask(Task task) throws TaskServiceException;

    public boolean deleteTask(Long taskId) throws TaskServiceException;

}
