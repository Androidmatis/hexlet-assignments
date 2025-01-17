package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskMapper taskMapper;

    @GetMapping(path = "")
    public List<TaskDTO> index() {
        return taskRepository.findAll().stream()
                .map(task -> taskMapper.map(task))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public TaskDTO index(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found!"));
        return taskMapper.map(task);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO dto) {
        var task = taskMapper.map(dto);
        var user = task.getAssignee();
        user.addTask(task);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @PutMapping(path = "/{id}")
    public TaskDTO update(@Valid @RequestBody TaskUpdateDTO dto, @PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found!"));
        taskMapper.update(dto, task);
        task.setAssignee(userRepository.findById(dto.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found!")));
        var user = task.getAssignee();
        user.addTask(task);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found!"));
        var user = task.getAssignee();
        user.removeTask(task);
        taskRepository.delete(task);
    }
    // END
}
