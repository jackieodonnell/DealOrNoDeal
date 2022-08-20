package com.dond;

import com.dond.application.Game;
import com.dond.ui.UserOutput;

public class DealOrNoDealCLI {

    public static void main(String[] args){
        Game game = new Game();
        UserOutput.printRules();
        game.run();
    }
}

