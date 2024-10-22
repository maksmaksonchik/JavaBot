package ru.urfu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Unit-тесты для класса MessageHandler */
class MessageHandlerTest {
    private MessageHandler messageHandler;

    /** Создаем экземпляр MessageHandler */
    @BeforeEach
    void setUp() {
        messageHandler = new MessageHandler();
    }


    /** Проверяем ответ на сообщение без команды (эхо) */
    @Test
    void testEcho() {
        String message = "Привет";

        String result = messageHandler.getAnswer(message);

        String expected = String.format("Ты написал:\n\n\"%s\"", message);

        Assertions.assertEquals(expected, result);
    }
}