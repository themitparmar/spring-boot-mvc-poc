package com.poc.controller;

import com.poc.model.Task;
import com.poc.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * @author Mitesh Parmar
 */
@Controller
public class TaskMvcController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskService taskService;

    @GetMapping("getAllTasks")
    public String getAllBooks(Model model) throws Exception {
        List<Task> taskList = taskService.searchTasks();
        model.addAttribute("tasks", taskList);
        return "list-tasks";
    }

    @RequestMapping(path = "/createTask", method = RequestMethod.POST)
    public String createOrUpdateTask(Task task) throws Exception {
        taskService.createOrUpdateTask(task);
        return "redirect:/getAllTasks";
    }

    @RequestMapping(path = {"/edit", "/edit/{taskId}"})
    public String editTaskById(Model model, @PathVariable("taskId") Optional<Long> taskId) throws Exception {
        if(taskId.isPresent()) {
            Task task = taskService.searchTaskById(taskId.get());
            model.addAttribute("task", task);
        } else {
            model.addAttribute("task", new Task());
        }
        return "add-edit-task";
    }

    @RequestMapping(path = "/delete/{taskId}")
    public String deleteTaskById(Model model, @PathVariable("taskId") Optional<Long> taskId) throws Exception {
        if(taskId.isPresent()) {
            taskService.deleteTask(taskId.get());
        }
        return "redirect:/getAllTasks";
    }
}
