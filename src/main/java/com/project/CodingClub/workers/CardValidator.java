package com.project.CodingClub.workers;

import com.project.CodingClub.entities.Card;
import com.project.CodingClub.handlers.Validator;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class CardValidator {


    @JobWorker(type = "validatingCard")
    public void handleJob(JobClient jobClient, ActivatedJob job) {
        System.out.println("validating card");

        Card card = Validator.getCard(job.getVariable("cardNumber"),
                job.getVariable("nameOnCard"),
                job.getVariable("cvc"),
                job.getVariable("balance"));

        jobClient.newCompleteCommand(job).
                variables(Map.of(
                        "valid",Validator.validate(card),
                        "failureReason",card.getFailureReason()
                )).
                send().
                join();
    }
}
