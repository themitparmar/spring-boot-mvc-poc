package com.poc.service.impl;

import com.poc.exception.TaskServiceException;
import com.poc.model.Task;
import com.poc.repository.TaskRepository;
import com.poc.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> searchTasks() throws TaskServiceException {
        List<Task> taskList = (List<Task>) taskRepository.findAll();
        if(!taskList.isEmpty()) {
            return taskList;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Task searchTaskById(Long taskId) throws TaskServiceException {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()) {
            return task.get();
        } else {
            throw new TaskServiceException("Task not found");
        }
    }

    @Override
    public Task createOrUpdateTask(Task task) throws TaskServiceException {
        if(null != task) {
            return taskRepository.save(task);
        } else {
            throw new TaskServiceException("Invalid data provided");
        }
    }

    @Override
    public boolean deleteTask(Long taskId) throws TaskServiceException {
        boolean isDeleted = false;
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()) {
            taskRepository.delete(task.get());
            isDeleted = true;
        } else {
            throw new TaskServiceException("No task exist for given taskId");
        }
        return isDeleted;
    }

}
