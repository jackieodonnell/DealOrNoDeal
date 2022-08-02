package com.dond.ui;

import com.dond.models.Case;
import java.util.List;

public class UserOutput {

    public static void printRules(){
        System.out.println("\n\nWelcome to DEAL OR NO DEAL!\n");
        System.out.println("How to Play:\n\t- There are 26 briefcases on the game board.");
        System.out.println("\t- Each case contains a hidden amount of cash inside.");
        System.out.println("\t- Select a briefcase to start the game. You will not open this case \n" +
                "\t\tuntil the end of the game. You will open the remaining cases in rounds.");
        System.out.println("\t- Each time you open a case, the cash amount inside will be revealed and \n" +
                "\t\tremoved from the board. The goal is to remove low value cases from the board.");
        System.out.println("\t- After each round, the Banker will call you with an offer to purchase your \n" +
                "\t\tunopened case, based on what he thinks your case is worth.");
        System.out.println("\t- You can accept the offer (DEAL!), or decline and continue playing (NO DEAL!)");
        System.out.println("\t- At the end of the game, we will open up your case and find out who got \n" +
                "\t\tthe better deal!");
    }
    public static void displayGameBoard(Case[] cases, List<Integer> values ){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("                         DEAL OR NO DEAL: CURRENT BOARD                               ");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(0)), cases[0].getDisplay(), cases[1].getDisplay(),
                cases[2].getDisplay(), cases[3].getDisplay(), cases[4].getDisplay(),displayValue(values.get(13)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(1)), displayValue(values.get(14)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(2)), cases[5].getDisplay(), cases[6].getDisplay(),
                cases[7].getDisplay(), cases[8].getDisplay(), cases[9].getDisplay(),displayValue(values.get(15)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(3)), displayValue(values.get(16)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(4)), cases[10].getDisplay(), cases[11].getDisplay(),
                cases[12].getDisplay(), cases[13].getDisplay(), cases[14].getDisplay(),displayValue(values.get(17)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(5)), displayValue(values.get(18)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(6)), cases[15].getDisplay(), cases[16].getDisplay(),
                cases[17].getDisplay(), cases[18].getDisplay(), cases[19].getDisplay(),displayValue(values.get(19)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(7)), displayValue(values.get(20)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(8)), cases[20].getDisplay(), cases[21].getDisplay(),
                cases[22].getDisplay(), cases[23].getDisplay(), cases[24].getDisplay(),displayValue(values.get(21)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(9)), displayValue(values.get(22)));
        System.out.printf("\n$%-37s%-37s$%-15s", displayValue(values.get(10)), cases[25].getDisplay(), displayValue(values.get(23)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(11)), displayValue(values.get(24)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(12)), displayValue(values.get(25)));
        System.out.println("\n--------------------------------------------------------------------------------------");
    }
    public static void displayGameBoard(Case[] cases, List<Integer> values, int playerCaseNumber){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("                         DEAL OR NO DEAL: CURRENT BOARD                               ");
        System.out.println("                                 Your Case #: " + playerCaseNumber                     );
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(0)), cases[0].getDisplay(), cases[1].getDisplay(),
                cases[2].getDisplay(), cases[3].getDisplay(), cases[4].getDisplay(),displayValue(values.get(13)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(1)), displayValue(values.get(14)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(2)), cases[5].getDisplay(), cases[6].getDisplay(),
                cases[7].getDisplay(), cases[8].getDisplay(), cases[9].getDisplay(),displayValue(values.get(15)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(3)), displayValue(values.get(16)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(4)), cases[10].getDisplay(), cases[11].getDisplay(),
                cases[12].getDisplay(), cases[13].getDisplay(), cases[14].getDisplay(),displayValue(values.get(17)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(5)), displayValue(values.get(18)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(6)), cases[15].getDisplay(), cases[16].getDisplay(),
                cases[17].getDisplay(), cases[18].getDisplay(), cases[19].getDisplay(),displayValue(values.get(19)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(7)), displayValue(values.get(20)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayValue(values.get(8)), cases[20].getDisplay(), cases[21].getDisplay(),
                cases[22].getDisplay(), cases[23].getDisplay(), cases[24].getDisplay(),displayValue(values.get(21)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(9)), displayValue(values.get(22)));
        System.out.printf("\n$%-37s%-37s$%-15s", displayValue(values.get(10)), cases[25].getDisplay(), displayValue(values.get(23)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(11)), displayValue(values.get(24)));
        System.out.printf("\n$%-74s$%-15s", displayValue(values.get(12)), displayValue(values.get(25)));
        System.out.println("\n--------------------------------------------------------------------------------------");
    }
    public static String displayValue(int caseValue){
        String displayValue = Integer.toString(caseValue);
        if (displayValue.equals("0")) {
            displayValue = "------";
        }
        return displayValue;
    }

    public static void displayNewRound(int roundNumber, int casesToOpen){
        System.out.println("ROUND " + roundNumber+": OPEN " + casesToOpen + " CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void displayRoundProgress(int roundNumber,int casesToOpen){
        System.out.println("ROUND " + roundNumber+ ": " + casesToOpen + " more case(s) to open.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void displayFinalRound(int casesToOpen){
        System.out.println("FINAL ROUND: OPEN " + casesToOpen + " CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
