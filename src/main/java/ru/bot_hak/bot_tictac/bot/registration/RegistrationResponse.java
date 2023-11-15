package ru.bot_hak.bot_tictac.bot.registration;

import lombok.Builder;
import ru.bot_hak.bot_tictac.bot.Figure;

@Builder
public record RegistrationResponse(
    Figure figure
) {}
