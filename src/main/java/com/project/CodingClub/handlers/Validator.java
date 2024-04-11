package com.project.CodingClub.handlers;

import com.project.CodingClub.entities.Card;

import java.util.Optional;

public class Validator {
    public static Card getCard(Object cardNumber, Object nameOnCard, Object cvc, Object balance) {
        Card card = new Card();
        card.setCardNumber(cardNumberValidator(cardNumber));
        card.setCvc(cvcValidator(cvc));
        card.setNameOnCard(nameOnCardValidator(nameOnCard));
        return card;
    }

    private static String nameOnCardValidator(Object nameOnCard) {
        Optional<String> nameOnCardOptional = Optional.ofNullable(nameOnCard)
                .map(Object::toString)
                .filter(s -> s.matches("^[a-zA-Z]+$"));

        return nameOnCardOptional.orElse(null);
    }

    private static Integer cvcValidator(Object cvc) {
        Optional<Integer> cvcOptional = Optional.ofNullable(cvc)
                .map(Object::toString)
                .filter(s -> s.matches("^\\d{3}$"))
                .map(Integer::parseInt);
        return cvcOptional.orElse(null);
    }

    private static Long cardNumberValidator(Object cardNumber) {
        Optional<Long> cardNumberOptional = Optional.ofNullable(cardNumber)
                .map(Object::toString)
                .filter(s -> s.matches("^\\d{16}$"))
                .map(Long::parseLong);
        return cardNumberOptional.orElse(null);
    }

    public static boolean validate(Card card) {
        return card.getCardNumber() != null && card.getCvc() != null && card.getNameOnCard() != null;
    }




}
