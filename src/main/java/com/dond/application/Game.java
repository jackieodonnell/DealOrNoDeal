package com.dond.application;

import com.dond.models.Banker;
import com.dond.models.Case;
import com.dond.ui.UserInput;
import com.dond.ui.UserOutput;
import java.util.*;

public class Game {
    private Banker banker = new Banker();
    private Case[] cases = new Case[26];
    private int playerCaseNumber = 0;
    private int offer = 0;
    boolean isDealAccepted = false;
    private List<Integer> values = Arrays.asList(1, 2, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000,
            25000, 50000,75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000);

    public void run(){
        SoundHandler.runMusic("Resources/Intro.wav");
        setupGame();
        for (int i = 1; i < 8; i++) {
            startRound(i);
            banker.bankerCalling();
            SoundHandler.runMusic("Resources/Thinking.wav");
            offer = banker.makeOffer(cases, playerCaseNumber);
            isDealAccepted = UserInput.promptDealOrNoDeal();
            if (!isDealAccepted) {
                SoundHandler.runMusic("Resources/NoDeal.wav");
                UserOutput.displayNoDeal();
            } else {
                SoundHandler.runMusic("Resources/Outro.wav");
                UserOutput.displayDeal();
                dealAccepted(offer);
                break;
            }
        }
        if (!isDealAccepted){
            SoundHandler.runMusic("Resources/Outro.wav");
            finalOfferDeclined(offer);
        }
    }

    public void setupGame() {
        caseSetup(cases);
        UserOutput.displayGameBoard(cases, values);
        playerCaseNumber = UserInput.selectFirstCase();
        cases[playerCaseNumber-1].setOpen(true);
        UserInput.promptEnter("update the Game Board");
        updateGameBoard(playerCaseNumber);
    }

    public static void caseSetup(Case[] cases){
        List<Integer> valuesShuffled = Arrays.asList(1, 2, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000,
                25000, 50000,75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000);;
        Collections.shuffle(valuesShuffled);
        for (int i = 0; i < cases.length; i++){
            cases[i] = new Case(i+1, valuesShuffled.get(i));
        }
    }

    public void startRound(int roundNumber){
        int casesPerRound = 0;
        if (roundNumber == 1) {
            casesPerRound = 6;
        } else if (roundNumber == 7) {
            finalRound();
        } else {
            if (roundNumber == 6) {
                casesPerRound = 1;
            } else if (roundNumber == 5) {
                casesPerRound = 3;
            } else if (roundNumber >= 3) {
                casesPerRound = 4;
            } else if (roundNumber == 2) {
                casesPerRound = 5;
            }
            UserOutput.displayGameBoard(cases, values, playerCaseNumber);
        }
        UserOutput.displayNewRound(roundNumber, casesPerRound);
        int casesToOpen = casesPerRound;
        for (int i = 0; i < casesPerRound; i++){
            int selectedCaseNumber = UserInput.selectACase();
            openCase(selectedCaseNumber);
            casesToOpen--;
            if (casesToOpen > 0){
                UserOutput.displayRoundProgress(roundNumber,casesToOpen);
            }
        }
    }

    public void finalRound(){
        int casesToOpen = 1;
        UserOutput.displayGameBoard(cases, values, playerCaseNumber);
        UserOutput.displayFinalRound(1);
        for (int i = 1; i <= 1; i++){
            int selectedCaseNumber = UserInput.selectACase();
            openCase(selectedCaseNumber);
            casesToOpen--;
            UserOutput.displayRoundProgress(6,casesToOpen);
        }
    }


    public void openCase(int selectedCaseNumber){
        int value = cases[selectedCaseNumber-1].getCaseValue();
        cases[selectedCaseNumber-1].setOpen(true);
        System.out.println("\n\t\tCase # " + selectedCaseNumber + " contains $" + value +"." + "\n ");
        UserInput.promptEnter("continue");
        updateGameBoard(selectedCaseNumber);
    }

    public void updateGameBoard(int selectedCaseNumber){
        if (selectedCaseNumber != playerCaseNumber) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) == cases[selectedCaseNumber - 1].getCaseValue()) {
                    values.set(i, 0);
                }
            }
        }
        UserOutput.displayGameBoard(cases, values, playerCaseNumber);
    }

    public void dealAccepted(int offerPrice){
        System.out.println("\n\t\tYou have accepted the Banker's offer for $" + offerPrice);
        System.out.println("\t\tNow let's find out how much money was inside your case...");
        UserInput.promptEnter("open your case");
        int playerCaseValue = cases[playerCaseNumber-1].getCaseValue();
        System.out.println("\n\t\tCase # " + playerCaseNumber + " contains $" + playerCaseValue);
        SoundHandler.runMusic("Resources/Outro.wav");
        boolean isGoodDeal = false;
        if (playerCaseValue < offerPrice) {
            isGoodDeal = true;
        }
        UserOutput.endGame(isGoodDeal);
    }

    public void finalOfferDeclined(int offerPrice){
        System.out.println("\n\t\tYou have declined the Banker's final offer for $" + offerPrice);
        System.out.println("\t\tThere is one remaining case on the board.");
        UserOutput.displayGameBoard(cases, values, playerCaseNumber);
        int finalCaseNumber = UserInput.selectFinalCase();
        openCase(finalCaseNumber);
        System.out.println("\t\tIt's time to open your case...");
        UserInput.promptEnter("open your case");
        int playerCaseValue = cases[playerCaseNumber-1].getCaseValue();
        System.out.println("\n\t\tCase # " + playerCaseNumber + " contains $" + playerCaseValue);
        SoundHandler.runMusic("Resources/Outro.wav");
        boolean isGoodDeal = false;
        if (playerCaseValue > offerPrice) {
            isGoodDeal = true;
        }
        UserOutput.endGame(isGoodDeal);
    }

}
