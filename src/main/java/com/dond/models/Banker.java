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
        int casesInPlay = 1;
        double newOffer = (cases[playerCaseNumber-1].getCaseValue() * cases[playerCaseNumber-1].getCaseValue());
        for (Case aCase : cases) {
            if (!aCase.isOpen()) {
                casesInPlay++;
                newOffer += (aCase.getCaseValue() * aCase.getCaseValue());
            }
        }
        newOffer /= casesInPlay;
        newOffer = Math.sqrt(newOffer);
        UserOutput.deliverOffer(currentOffer, (int) newOffer);
        currentOffer = (int) newOffer;
        return currentOffer;
    }
}
