import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Game game = new Game();
        Banker banker = new Banker();
        game.startGame();

        System.out.println("\nROUND ONE: OPEN 6 CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 1; i <=6; i++){
            int selectedCaseNumber = game.selectACase();
            game.openCase(selectedCaseNumber);
        }
        banker.bankerCalling();
        int offer1 = banker.getOffer(game);

        System.out.println("\nLet's continue...\nROUND TWO: OPEN 6 CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        game.displayGameBoard();
        for (int i = 1; i <=6; i++){
            int selectedCaseNumber = game.selectACase();
            game.openCase(selectedCaseNumber);
        }
        banker.bankerCalling();
        int offer2 = banker.getOffer(game, offer1);

        System.out.println("\nLet's continue...\nROUND THREE: OPEN 5 CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        game.displayGameBoard();
        for (int i = 1; i <=5; i++){
            int selectedCaseNumber = game.selectACase();
            game.openCase(selectedCaseNumber);
        }
        banker.bankerCalling();
        int offer3 = banker.getOffer(game, offer2);

        System.out.println("\nLet's continue...\nROUND FOUR: OPEN 3 CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        game.displayGameBoard();
        for (int i = 1; i <=3; i++){
            int selectedCaseNumber = game.selectACase();
            game.openCase(selectedCaseNumber);
        }
        banker.bankerCalling();
        int offer4 = banker.getOffer(game, offer3);

        System.out.println("\nLet's continue...\nROUND FIVE: OPEN 3 CASES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        game.displayGameBoard();
        for (int i = 1; i <=3; i++){
            int selectedCaseNumber = game.selectACase();
            game.openCase(selectedCaseNumber);
        }
        banker.bankerCalling();
        int offer5 = banker.getOffer(game, offer4);



    }



}
