package com.project.CodingClub.workers;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class ChargingWorker {


    @JobWorker(type = "chargeCard")
    public void chargeCard(JobClient jobClient, ActivatedJob job) {
        Double amountToPay = (Double) job.getVariable("newToPay");
        Double amountInCard = (Double) job.getVariable("balance");
        Double newBalance = amountInCard - amountToPay;
        if(newBalance < 0){
            jobClient.newThrowErrorCommand(job)
                    .errorCode("Insufficient funds")
                    .send()
                    .join();
        } else {
            jobClient.newCompleteCommand(job)
                    .variables("{\"balance\": " + newBalance + "}")
                    .send()
                    .join();
        }
    }
}
