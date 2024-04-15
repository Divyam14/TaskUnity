package com.pheonix.TaskUnity.controller;


import com.pheonix.TaskUnity.models.Task;
import com.pheonix.TaskUnity.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    TaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task) throws Exception{

        Task newTask = taskService.addTask(task);

        if(newTask == null){
            throw new Exception();
        }

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable int taskId){
        try {
            Task task = taskService.getTask(taskId);

            return new ResponseEntity<>(task,HttpStatus.OK);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable int taskId){
        Task updatedTask = taskService.updateTask(taskId,task);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

}
