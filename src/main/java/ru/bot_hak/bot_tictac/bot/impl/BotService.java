package ru.bot_hak.bot_tictac.bot.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.bot_hak.bot_tictac.bot.Figure;
import ru.bot_hak.bot_tictac.bot.negamax.Move;
import ru.bot_hak.bot_tictac.bot.negamax.NegamaxPlayer;
import ru.bot_hak.bot_tictac.bot.registration.BotRegistrationService;

import java.util.Stack;

@Service
public class BotService {

    private final Figure figure;
    private final Stack<String> movesStr;

    public BotService(
            BotRegistrationService registrationService,
            Stack<String> movesStr) {
        figure = registrationService.getFigure();
        this.movesStr = movesStr;
    }
    public Move strToMove(String moveOpponent){
        String ourPreviousMove = movesStr.peek();
        for (int i = 0; i < 361; i++) {
            if (moveOpponent.charAt(i) != ourPreviousMove.charAt(i)) {
                return new Move(i / 19, i % 19);
            }
        }
        return null;
    }

//    public String processingBot(String moveOpponent){
////        if (moveOpponent.replaceAll("_", moveOpponent).isBlank())
////        return String.replace(moveOpponent, newTurnIdx + 1, figure.getName()).toString();
//    }



}
