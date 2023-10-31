package itmo.airbnb.camunda;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import itmo.airbnb.dto.request.ListingCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class ListingWorkers {
    @JobWorker(type = "job_prepare_listing")
    public Object prepareListing(final JobClient jobClient, final ActivatedJob job, @VariablesAsType ListingCreateRequest variables) {
        System.out.println("CREATE LISTING CREATION PROCESS");
        return variables;
    }

    @JobWorker(type = "job_create_listing")
    public Object createListing(final JobClient jobClient, final ActivatedJob job, @VariablesAsType ListingCreateRequest variables) {
        //TODO: save in database or not approve
        return variables;
    }
}
