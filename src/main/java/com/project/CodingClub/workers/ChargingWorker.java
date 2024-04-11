package com.project.CodingClub.workers;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class ChargingWorker {


    @JobWorker(type = "chargeCard")
    public void handleJob() {
        System.out.println("Handling job");
    }
}
