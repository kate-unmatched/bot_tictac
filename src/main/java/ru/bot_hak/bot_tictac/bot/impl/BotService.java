package ru.bot_hak.bot_tictac.bot.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bot_hak.bot_tictac.bot.Figure;
import ru.bot_hak.bot_tictac.bot.negamax.Move;
import ru.bot_hak.bot_tictac.bot.negamax.NegamaxPlayer;
import ru.bot_hak.bot_tictac.bot.negamax.State;
import ru.bot_hak.bot_tictac.bot.registration.BotRegistrationService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class BotService {

    private final Figure figure;
    private final NegamaxPlayer negamaxPlayer;
    private String ourLastMoveStr = "________________________________________________________________________________" +
            "_______________________________________________________________________________________________________" +
            "________________________________________________________________________________________________________" +
            "__________________________________________________________________________";
    private final Set<Integer> busy = new HashSet<>();

    @Autowired
    public BotService(
            BotRegistrationService registrationService, NegamaxPlayer negamaxPlayer) {
        figure = registrationService.getFigure();
        this.negamaxPlayer = negamaxPlayer;
    }


    public Move strToMove(String moveOpponent) {
        for (int i = 0; i < 361; i++) {
            if (busy.contains(i)) continue;
            if (moveOpponent.charAt(i) != ourLastMoveStr.charAt(i)) {
                busy.add(i);
                return new Move(i / 19, i % 19);
            }
        }
        return null;
    }

    public String moveToStr(Move ourMove, String moveOpponent) {
        int index = ourMove.getRow() * 19 + ourMove.getCol();
        return new StringBuilder(moveOpponent).replace(index, index + 1, figure.getName()).toString();
    }

    public String processingBot(String moveOpponent) {
        Move moveOp = strToMove(moveOpponent);
        if (!Objects.isNull(moveOp)) {
            ourLastMoveStr = moveToStr(negamaxPlayer.getMove(moveOp), moveOpponent);
        } else {
            ourLastMoveStr = moveToStr(negamaxPlayer.beginGame(), moveOpponent);
        }
        return ourLastMoveStr;
    }


}
