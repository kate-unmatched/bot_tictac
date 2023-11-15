package ru.bot_hak.bot_tictac.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;

@ConfigurationProperties(prefix = "config")
public record BotConfig(
    String mediatorAddress,
    String botUrl,
    String botId,
    String botPassword,
    UUID sessionUUID,
    int gameFieldSize
) {}
