package com.pheonix.TaskUnity.services;


import com.pheonix.TaskUnity.models.Task;
import com.pheonix.TaskUnity.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task){
        try {
            task.setCreatedAt(new Date());
            task.setUpdatedAt(new Date());
            return taskRepository.save(task);
        }catch (Exception e){
            logger.error(e.getMessage());
        }return null;
    }

    public Task getTask(int id) throws Exception{
        try{
            Optional<Task> task = taskRepository.findById(id);
            if(task.isEmpty()){
                throw new Exception("Task not found");
            }

            return task.get();
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
}
