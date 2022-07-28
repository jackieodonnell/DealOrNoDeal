package com.dond.ui;

import com.dond.application.Game;

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

    public static void promptEnterToOpen() {
        System.out.print("\n>>>Press \"ENTER\" to open the case>>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void promptEnterToUpdateGameBoard() {
        System.out.print("\n>>>Press \"ENTER\" to update the Game Board>>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static int selectACase() {
        System.out.printf("\n>>>Select a case # : ");
        int selectedCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("\n\t\tYou have selected case # " + selectedCaseNumber + ".");
        promptEnterToOpen();
        return selectedCaseNumber;
    }
}
