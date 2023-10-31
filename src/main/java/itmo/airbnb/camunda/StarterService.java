package itmo.airbnb.camunda;

import io.camunda.zeebe.client.ZeebeClient;
import itmo.airbnb.dto.request.ListingCreateRequest;
import itmo.airbnb.dto.request.UserLoginRequest;
import org.springframework.stereotype.Service;

@Service
public class StarterService {
    private static String LISTING_CREATION_PROCESS_ID = "listing_creation_process";
    private static String HOST_CREATION_PROCESS_ID = "host_creation_process";
    private final ZeebeClient zeebeClient;

    public StarterService(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    public void startListingCreationProcess(ListingCreateRequest request) {
        zeebeClient
                .newCreateInstanceCommand()
                .bpmnProcessId(LISTING_CREATION_PROCESS_ID)
                .latestVersion()
                .variables(request)
                .send()
                .join();
    }

    public void startHostCreationProcess(UserLoginRequest request) {
        zeebeClient
                .newCreateInstanceCommand()
                .bpmnProcessId(HOST_CREATION_PROCESS_ID)
                .latestVersion()
                .variables(request)
                .send()
                .join();
    }


}
