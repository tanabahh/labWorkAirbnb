package itmo.airbnb;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath*:/model/*.*")
public class AirbnbApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AirbnbApplication.class, args);
    }

}
