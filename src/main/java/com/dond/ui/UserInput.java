package com.dond.ui;

import java.io.IOException;
import java.util.Scanner;

public class UserInput {
    private static Scanner input = new Scanner(System.in);

    public static int selectFirstCase() {
        System.out.print(">>>Select a case to start the game: ");
        int playerCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("\n\t\tYou have selected case # " + playerCaseNumber + ".");
        return playerCaseNumber;
    }

    public static int selectACase() {
        System.out.printf("\n>>>Select a case # : ");
        int selectedCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("\n\t\tYou have selected case # " + selectedCaseNumber + ".");
        promptEnter("open the case");
        return selectedCaseNumber;
    }

    public static int selectFinalCase() {
        System.out.printf("\n>>>Select the last remaining case # : ");
        int selectedCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("\n\t\tYou have selected case # " + selectedCaseNumber + ".");
        promptEnter("open the case");
        return selectedCaseNumber;
    }

    public static void promptEnter(String message){
        System.out.print("\n>>>Press \"ENTER\" to " + message + ">>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void prepOffer(int playerCaseNumber){
        System.out.println("\n\t\tThe Banker would like to make an offer on your case, Case # "
                + playerCaseNumber + "...");
        promptEnter("hear the offer");
    }

    public static boolean promptDealOrNoDeal() {
        boolean isDealAccepted = false;
        System.out.println("\n\t\tHow would you like to respond to this offer?");
        System.out.println("\t\t   [1] DEAL     or     [2] NO DEAL  ");

        input = new Scanner(System.in);
        System.out.print("\n>>>Enter choice [1] or [2]: ");
        int playerChoice = Integer.parseInt(input.nextLine());

        if (playerChoice == 1) {
            isDealAccepted = true;
        }
        return isDealAccepted;
    }


}
