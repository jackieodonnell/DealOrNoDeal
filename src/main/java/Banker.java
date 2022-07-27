import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banker {


    public void bankerCalling() {
        System.out.println("\n*******************************");
        System.out.println("*** RING RING *** RING RING ***");
        System.out.println("*******************************");
        System.out.println("The Banker is calling!");
        System.out.println("Press \"ENTER\" to answer the phone >>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public int getOffer(Game game) {
        System.out.println("\nThe Banker would like to make an offer on your case, Case # "
                + game.getPlayerCaseNumber() + "...");
        System.out.println("Press \"ENTER\" to hear the offer >>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
        Case[] cases = game.getCases();
        int casesInPlay = 0;
        int moneyInPlay = 0;
        for (Case aCase : cases) {
            if (!(aCase.isOpen())) {
                casesInPlay++;
                moneyInPlay += aCase.getCaseValue();
            }
        }
        int offerPrice = moneyInPlay / casesInPlay;
        if (casesInPlay > 18) {
            offerPrice /= 3;
        } else if (casesInPlay > 13) {
            offerPrice /= 2;
        }
        System.out.println("The Banker is offering: $" + offerPrice + ".");

        System.out.println("\nHow would you like to respond to this offer?");
        System.out.println("   [1] DEAL     or     [2] NO DEAL  ");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a choice >>> ");
        int playerChoice = Integer.parseInt(input.nextLine());
        if (playerChoice == 1) {
            System.out.println("\n*******************************");
            System.out.println("             DEAL!!!           ");
            System.out.println("*******************************");
            game.dealAccepted(offerPrice);

        } else if (playerChoice == 2) {
            System.out.println("\n*******************************");
            System.out.println("           NO DEAL!!!          ");
            System.out.println("*******************************");
        }
        return offerPrice;

    }

    public int getOffer(Game game, int previousOffer) {
        System.out.println("\nThe Banker would like to make an offer on your case, Case # "
                + game.getPlayerCaseNumber() + "...");

        Case[] cases = game.getCases();
        int casesInPlay = 0;
        int moneyInPlay = 0;
        for (Case aCase : cases) {
            if (!(aCase.isOpen())) {
                casesInPlay++;
                moneyInPlay += aCase.getCaseValue();
            }
        }
        int offerPrice = moneyInPlay / casesInPlay;
        if (casesInPlay > 18) {
            offerPrice /= 3;
        } else if (casesInPlay > 13) {
            offerPrice /= 2;
        }

        if (offerPrice > previousOffer) {
            System.out.println("Good news! The Banker has raised his offer...");
        } else if (offerPrice < previousOffer) {
            System.out.println("Bad news... the Banker has lowered his offer...");
        }
        System.out.println("Press \"ENTER\" to hear the offer >>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("The Banker is offering: $" + offerPrice + ".");

        System.out.println("\nHow would you like to respond to this offer?");
        System.out.println("   [1] DEAL     or     [2] NO DEAL  ");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a choice >>> ");
        int playerChoice = Integer.parseInt(input.nextLine());
        if (playerChoice == 1) {
            System.out.println("\n*******************************");
            System.out.println("             DEAL!!!           ");
            System.out.println("*******************************");
            game.dealAccepted(offerPrice);

        } else if (playerChoice == 2) {
            System.out.println("\n*******************************");
            System.out.println("           NO DEAL!!!          ");
            System.out.println("*******************************");
        }
        return offerPrice;
    }
}
