package com.project.CodingClub.workers;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class ChargingWorker {


    @JobWorker(type = "chargeCard")
    public void chargeCard(JobClient jobClient, ActivatedJob job) {
        System.out.println("Handling job");
    }
}
