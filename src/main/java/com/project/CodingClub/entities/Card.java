package com.project.CodingClub.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long cardNumber;
    private Integer cvc;
    private String nameOnCard;
    private Float balance;
}
