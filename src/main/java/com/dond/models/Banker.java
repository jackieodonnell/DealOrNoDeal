package com.dond.models;

import com.dond.application.SoundHandler;
import com.dond.ui.UserInput;
import com.dond.ui.UserOutput;

public class Banker {
    private int currentOffer = 0;

    public void bankerCalling() {
        SoundHandler.runMusic("Resources/Phone.wav");
        UserOutput.phoneRing();
        UserInput.promptEnter("answer the phone");
    }

    public int makeOffer(Case[] cases, int playerCaseNumber) {
        UserInput.prepOffer(playerCaseNumber);
        int playerCaseIndex = playerCaseNumber - 1;
        int casesInPlay = 1; // the player's case "isOpen" but its value is still displayed on the game board,
            // so initialize the count of available cases at 1

        // initialize the new offer price = the player's case value squared
        double newOffer = (cases[playerCaseIndex].getCaseValue() * cases[playerCaseIndex].getCaseValue());

        // find the sum of the squared values of all available (unopened) cases...
        for (Case c : cases) {
            if (!c.isOpen()) { // if case is not open,
                casesInPlay++; // increment the count of available cases
                newOffer += (c.getCaseValue() * c.getCaseValue()); // square the value and add to newOffer
            }
        }
        newOffer /= casesInPlay; // divide by number of available cases to get the mean
        newOffer = Math.sqrt(newOffer); // find the square root of the mean
        UserOutput.deliverOffer(currentOffer, (int) newOffer);
        currentOffer = (int) newOffer; // update the value of the current offer
        return currentOffer; // return newly updated offer price to the Game class
    }
}




