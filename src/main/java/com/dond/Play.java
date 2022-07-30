package com.dond;

import com.dond.application.Game;
import com.dond.models.Banker;
import com.dond.ui.UserOutput;
import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

public class Play {
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        Game game = new Game();
        Banker banker = new Banker();
        UserOutput.printRules();
        game.startGame();
        game.startRound(1, 6);
        banker.bankerCalling();
        int offer1 = banker.getOffer(game);

        game.startRound(2, 5);
        banker.bankerCalling();
        int offer2 = banker.getOffer(game, offer1);

        game.startRound(3, 5);
        banker.bankerCalling();
        int offer3 = banker.getOffer(game, offer2);

        game.startRound(4, 3);
        banker.bankerCalling();
        int offer4 = banker.getOffer(game, offer3);

        game.startRound(5, 3);
        banker.bankerCalling();
        int offer5 = banker.getOffer(game, offer4);

        game.finalRound(6, 2);
        banker.bankerCalling();
        banker.getFinalOffer(game, offer5);
    }
}

