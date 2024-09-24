package ru.urfu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageHandlerTest {
    private MessageHandler messageHandler;

    @BeforeEach
    void setUp() {
        messageHandler = new MessageHandler();
    }

    @Test
    void getAnswer_start() {
        String result = messageHandler.getAnswer("/start");

        String expected = MessageConstants.HELLO + MessageConstants.DELIMITER + MessageConstants.HELP;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAnswer_help() {
        String result = messageHandler.getAnswer("/help");

        String expected = MessageConstants.HELP;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAnswer_echo() {
        String message = "Привет";

        String result = messageHandler.getAnswer(message);

        String expected = MessageConstants.ECHO_PREFIX +
                MessageConstants.DELIMITER +
                MessageConstants.QUOTE +
                message +
                MessageConstants.QUOTE;

        Assertions.assertEquals(expected, result);
    }
}