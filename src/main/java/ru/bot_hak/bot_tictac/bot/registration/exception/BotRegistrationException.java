package ru.bot_hak.bot_tictac.bot.registration.exception;

public class BotRegistrationException extends RuntimeException {
    public BotRegistrationException() {
        super("Ошибка регистрации бота в сессии");
    }
}
