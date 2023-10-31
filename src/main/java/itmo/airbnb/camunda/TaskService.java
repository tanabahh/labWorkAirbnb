package itmo.airbnb.camunda;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ZeebeClient zeebeClient;

    TaskService(TaskRepository taskRepository, ZeebeClient zeebeClient) {
        this.taskRepository = taskRepository;
        this.zeebeClient = zeebeClient;
    }

    public List<TaskEntity> getTasks() {
        return taskRepository.findAll();
    }

    public TaskEntity getTask(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public void complete(Long id, boolean approve) {
        TaskEntity task = taskRepository.findById(id).orElseThrow();
        zeebeClient.newCompleteCommand(task.getCamundaId()).variables(approve).send();
        taskRepository.delete(task);
    }
}
