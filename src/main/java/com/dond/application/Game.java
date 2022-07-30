package com.dond.application;

import com.dond.models.Case;
import com.dond.ui.UserInput;
import com.dond.ui.UserOutput;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Game {
    private Case[] cases = new Case[26];
    private List<Integer> values = Arrays.asList(1, 2, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000,
            25000, 50000,75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000);
    private int playerCaseNumber = 0;

    public Case[] getCases() {
        return cases;
    }

    public int getPlayerCaseNumber() {
        return playerCaseNumber;
    }

    public void startGame() {
        caseSetup(cases);
        UserOutput.displayGameBoard(cases, values);
        playerCaseNumber = UserInput.selectFirstCase();
        cases[playerCaseNumber-1].setOpen(true);
        UserInput.promptEnterToUpdateGameBoard();
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

    public void startRound(int roundNumber, int casesToOpen) throws FileNotFoundException, JavaLayerException {
        int casesPerRound = casesToOpen;
        UserOutput.displayGameBoard(cases, values, playerCaseNumber);
        UserOutput.displayNewRound(roundNumber, casesPerRound);
        for (int i = 1; i <= casesPerRound; i++){
            int selectedCaseNumber = UserInput.selectACase();
            openCase(selectedCaseNumber);
            casesToOpen--;
            UserOutput.displayRoundProgress(roundNumber,casesToOpen);
        }
    }
    public void finalRound(int roundNumber, int casesToOpen) throws FileNotFoundException, JavaLayerException {
        int casesPerRound = casesToOpen;
        UserOutput.displayGameBoard(cases, values, playerCaseNumber);
        UserOutput.displayFinalRound(roundNumber, casesPerRound);
        for (int i = 1; i <= casesPerRound; i++){
            int selectedCaseNumber = UserInput.selectACase();
            openCase(selectedCaseNumber);
            casesToOpen--;
            UserOutput.displayRoundProgress(roundNumber,casesToOpen);
        }
    }

    public static void promptEnterToOpen(){
        System.out.print("\n>>>Press \"ENTER\" to open the case>>>");
        try {
            System.in.read();
        } catch (IOException e){
            e.getMessage();
        }
    }

    public void openCase(int selectedCaseNumber) throws FileNotFoundException, JavaLayerException {
        int value = cases[selectedCaseNumber-1].getCaseValue();
        cases[selectedCaseNumber-1].setOpen(true);
        System.out.println("\n\t\tCase # " + selectedCaseNumber + " contains $" + value +"." + "\n ");
/*        FileInputStream aww = new FileInputStream("Aww.mp3");
        Player playAww = new Player(aww);
        FileInputStream applause = new FileInputStream("claps3.mp3");
        Player playApplause = new Player(applause);
        if (value >= 1000){
            playAww.play();
        } else {
            playApplause.play();
        }*/
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
        promptEnterToOpen();
        int playerCaseValue = cases[playerCaseNumber-1].getCaseValue();
        System.out.println("\n\t\tCase # " + playerCaseNumber + " contains $" + playerCaseValue);
        if (playerCaseValue > offerPrice){
            System.out.println("\n\t\tBetter luck next time! :(");
        } else {
            System.out.println("\n\t\tWhew, looks like you made a good deal! :)");
        }
        System.out.println("\n\n-----------------------------------------------------------------------------------");
        System.out.println("                        Game over. Thank you for playing! ");
        System.exit(1);
    }

    public void finalOfferDeclined(int offerPrice) throws FileNotFoundException, JavaLayerException {
        System.out.println("\n\t\tYou have declined the Banker's final offer for $" + offerPrice);
        System.out.println("\t\tThere is one remaining case on the board.");
        UserOutput.displayGameBoard(cases, values, playerCaseNumber);
        int finalCaseNumber = UserInput.selectFinalCase();
        openCase(finalCaseNumber);
        System.out.println("\t\tIt's time to open your case...");
        promptEnterToOpen();
        int playerCaseValue = cases[playerCaseNumber-1].getCaseValue();
        System.out.println("\n\t\tCase # " + playerCaseNumber + " contains $" + playerCaseValue);
        if (playerCaseValue < offerPrice){
            System.out.println("\n\t\tBetter luck next time! :(");
        } else {
            System.out.println("\n\t\tWhew, looks like you made the right call! :)");
        }
        System.out.println("\n\n-----------------------------------------------------------------------------------");
        System.out.println("                        Game over. Thank you for playing! ");
        System.exit(1);

    }

}
