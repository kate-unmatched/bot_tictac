package ru.bot_hak.bot_tictac.bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bot_hak.bot_tictac.bot.BotService;

@RestController
@RequiredArgsConstructor
public class BotController {
    private final BotService botService;

//    @PostMapping("/bot/turn")
//    public GameFieldResponseDto makeTurn(@RequestParam String opponentMove) {
//        String newGameField = botService.makeTurnByGameField(gameField);
//        return GameFieldResponseDto.builder().gameField(newGameField).build();
//    }
}
