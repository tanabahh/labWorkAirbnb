package itmo.airbnb.camunda;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import itmo.airbnb.dto.request.ListingCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class HostWorkers {
    @JobWorker(type = "job_prepare_host")
    public Object prepareListing(final JobClient jobClient, final ActivatedJob job, @VariablesAsType ListingCreateRequest variables) {
        System.out.println("CREATE LISTING CREATION PROCESS");
        return variables;
    }

    @JobWorker(type = "job_create_host")
    public Object createListing(final JobClient jobClient, final ActivatedJob job, @VariablesAsType ListingCreateRequest variables) {
        //TODO: save in database or not approve
        return variables;
    }

    @JobWorker(type = "job_reject_host")
    public Object rejectListing(final JobClient jobClient, final ActivatedJob job,
                                @VariablesAsType ListingCreateRequest variables) {
        //TODO: save in database or not approve
        return variables;
    }
}