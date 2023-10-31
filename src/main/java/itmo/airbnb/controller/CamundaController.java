package itmo.airbnb.controller;

import itmo.airbnb.camunda.TaskEntity;
import itmo.airbnb.camunda.TaskService;
import itmo.airbnb.dto.response.ListingGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/camunda")
@PreAuthorize("hasRole('ADMIN')")
public class CamundaController {

    private final TaskService taskService;

    public CamundaController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/task")
    @ResponseBody
    public List<TaskEntity> get() {
        return taskService.getTasks();
    }

    @GetMapping(value = "/task/{id}") //TODO: approve or not approve
    public ResponseEntity<Void> complete(@PathVariable("id") Long id) {
        taskService.complete(id);
        return ResponseEntity.ok().build();
    }

}
