package ru.urfu;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/** Класс телеграм бота */
public class TelegramBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final MessageHandler messageHandler;

    public TelegramBot(String token) {
        telegramClient = new OkHttpTelegramClient(token);
        messageHandler = new MessageHandler();
    }

    /** Метод обрабатывающий обновление состояния бота, полученное от АПИ */
    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            String answerText = messageHandler.getAnswer(messageText);

            SendMessage message = SendMessage
                    .builder()
                    .chatId(chatId)
                    .text(answerText)
                    .build();
            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}