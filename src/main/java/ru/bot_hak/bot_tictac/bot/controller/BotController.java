package ru.bot_hak.bot_tictac.bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bot_hak.bot_tictac.bot.impl.BotService;

@RestController
@RequiredArgsConstructor
public class BotController {
    private final BotService botService;

    @PostMapping("/bot/turn")
    public GameFieldResponseDto makeTurn(@RequestBody GameFieldRequestDto opponentMove) {
        return GameFieldResponseDto.builder().gameField(botService.processingBot(opponentMove.gameField())).build();
    }
}
