package itmo.airbnb.camunda;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskHandler implements JobHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskHandler.class);
    private final TaskRepository taskRepository;

    public TaskHandler(TaskRepository repository) {
        this.taskRepository = repository;
    }

    /**
     * Handle created task in zeebe and create one in our database
     *
     * @param client - zeebe job client
     * @param job    - job that activated creating task
     */
    @Override
    @JobWorker(autoComplete = false, type = "io.camunda.zeebe:userTask")
    public void handle(JobClient client, ActivatedJob job) {
        LOGGER.info("Handle task with job id {}", job.getKey());
        TaskEntity task = new TaskEntity();
        task.setCamundaId(job.getKey());
        task.setVariables(job.getVariables());
        //task.setType(); TODO: maybe
        taskRepository.save(task);
    }
}

