package com.project.CodingClub.handlers;

import com.project.CodingClub.entities.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void getCardNumberValid() {
        Card card = Validator.getCard(1111111111111111L, "John Doe", 123, 100);

        assertEquals(1111111111111111L, card.getCardNumber());
    }
    @Test
    void getCardNumberInvalid() {
        Card card = Validator.getCard(11111111L, "John Doe", 123, 100);

        assertNull(card.getCardNumber());
    }
}