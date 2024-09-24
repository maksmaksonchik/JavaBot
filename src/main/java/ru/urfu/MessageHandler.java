package ru.urfu;

/** Класс для обработки сообщений пользователя */
public class MessageHandler {
    /** Возвращает ответ на сообщение пользователя */
    public String getAnswer(String message) {
        return switch (message) {
            case "/start" -> getStartAnswer();
            case "/help" -> getHelpAnswer();
            default -> getEchoAnswer(message);
        };
    }

    /** Возвращает ответ для команды /start */
    private String getStartAnswer() {
        return getComplexAnswer(MessageConstants.HELLO, MessageConstants.HELP);
    }

    /** Возвращает ответ для команды /help */
    private String getHelpAnswer() {
        return MessageConstants.HELP;
    }

    /** Возвращает эхо-ответ для сообщения без команды */
    private String getEchoAnswer(String message) {
        return getComplexAnswer(MessageConstants.ECHO_PREFIX, wrapWithQuotes(message));
    }

    /** Оборачивает текст в кавычки */
    private String wrapWithQuotes(String text) {
        return MessageConstants.QUOTE + text + MessageConstants.QUOTE;
    }

    /** Складывает несколько строк ответа через разделитель */
    private String getComplexAnswer(String ...texts) {
        return String.join(MessageConstants.DELIMITER, texts);
    }
}
