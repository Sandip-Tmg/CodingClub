package com.project.CodingClub.workers;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;


@Component
public class testWorker {


    @JobWorker(type = "validatingCard")
    public void handleJob(JobClient jobClient, ActivatedJob job) {
        System.out.println("validating card");
        jobClient.newCompleteCommand(job).variable("valid", false).send().join();
    }
}
