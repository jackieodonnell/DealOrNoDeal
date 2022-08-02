package com.dond.models;

import com.dond.application.Game;
import java.io.IOException;
import java.util.Scanner;

public class Banker {


    public void bankerCalling(){
        System.out.println("\n\t\t*******************************");
        System.out.println("\t\t*** RING RING *** RING RING ***");
        System.out.println("\t\t*******************************");
        System.out.println("\n\t\tThe Banker is calling!");

        System.out.print("\n>>>Press \"ENTER\" to answer the phone>>>");
        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public int getOffer(Game game) {
        System.out.println("\n\t\tThe Banker would like to make an offer on your case, Case # "
                + game.getPlayerCaseNumber() + "...");
        System.out.print("\n>>>Press \"ENTER\" to hear the offer>>>");
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
        System.out.println("\n\t\tThe Banker is offering: $" + offerPrice + ".");

        System.out.println("\n\t\tHow would you like to respond to this offer?");
        System.out.println("\t\t   [1] DEAL     or     [2] NO DEAL  ");

        Scanner input = new Scanner(System.in);
        System.out.print("\n>>>Enter choice [1] or [2]: ");
        int playerChoice = Integer.parseInt(input.nextLine());
        if (playerChoice == 1) {
            System.out.println("\n\t\t*******************************");
            System.out.println("\t\t             DEAL!!!           ");
            System.out.println("\t\t*******************************");
            game.dealAccepted(offerPrice);

        } else if (playerChoice == 2) {
            System.out.println("\n\t\t*******************************");
            System.out.println("\t\t           NO DEAL!!!          ");
            System.out.println("\t\t*******************************");
        }
        return offerPrice;
    }

    public int getOffer(Game game, int previousOffer) {
        System.out.println("\n\t\tThe Banker would like to make an offer on your case, Case # "
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
            System.out.println("\n\t\tGood news! The Banker has raised his offer...");
        } else if (offerPrice < previousOffer) {
            System.out.println("\n\t\tBad news... the Banker has lowered his offer...");
        }
        System.out.print("\n>>>Press \"ENTER\" to hear the offer>>>");

        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }

        System.out.println("\n\t\tThe Banker is offering: $" + offerPrice + ".");
        System.out.println("\n\t\tHow would you like to respond to this offer?");
        System.out.println("\t\t   [1] DEAL     or     [2] NO DEAL  ");

        Scanner input = new Scanner(System.in);
        System.out.print("\n>>>Enter choice [1] or [2]: ");
        int playerChoice = Integer.parseInt(input.nextLine());
        if (playerChoice == 1) {
            System.out.println("\n\t\t*******************************");
            System.out.println("\t\t             DEAL!!!           ");
            System.out.println("\t\t*******************************");
            game.dealAccepted(offerPrice);

        } else if (playerChoice == 2) {
            System.out.println("\n\t\t*******************************");
            System.out.println("\t\t           NO DEAL!!!          ");
            System.out.println("\t\t*******************************");
        }
        return offerPrice;
    }

    public int getFinalOffer(Game game, int previousOffer){
        System.out.println("\n\t\tThe Banker would like to make one last offer on your case, Case # "
                + game.getPlayerCaseNumber() + "...");

        Case[] cases = game.getCases();
        int casesInPlay = 0;
        int moneyInPlay = cases[game.getPlayerCaseNumber()-1].getCaseValue();
        for (Case aCase : cases) {
            if (!(aCase.isOpen())) {
                casesInPlay++;
                moneyInPlay += aCase.getCaseValue();
            }
        }
        int offerPrice = moneyInPlay / (casesInPlay + 1);
        if (casesInPlay > 18) {
            offerPrice /= 3;
        } else if (casesInPlay > 7) {
            offerPrice /= 2;
        }

        System.out.println("\n\t\tThis will be his final offer...");
        System.out.print("\n>>>Press \"ENTER\" to hear the offer>>>");

        try {
            System.in.read();
        } catch (IOException e) {
            e.getMessage();
        }

        System.out.println("\n\t\tThe Banker is offering: $" + offerPrice + ".");
        System.out.println("\n\t\tHow would you like to respond to this offer?");
        System.out.println("\t\t   [1] DEAL     or     [2] NO DEAL  ");

        Scanner input = new Scanner(System.in);
        System.out.print("\n>>>Enter choice [1] or [2]: ");
        int playerChoice = Integer.parseInt(input.nextLine());
        if (playerChoice == 1) {
            System.out.println("\n\t\t*******************************");
            System.out.println("\t\t             DEAL!!!           ");
            System.out.println("\t\t*******************************");
            game.dealAccepted(offerPrice);

        } else if (playerChoice == 2) {
            System.out.println("\n\t\t*******************************");
            System.out.println("\t\t           NO DEAL!!!          ");
            System.out.println("\t\t*******************************");
            game.finalOfferDeclined(offerPrice);
        }
        return offerPrice;
    }
}
