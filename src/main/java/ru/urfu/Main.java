package ru.urfu;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {

        String botToken = System.getenv("BOT_TOKEN");

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new Bot(botToken));
            System.out.println("Bot successfully started!");

            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}