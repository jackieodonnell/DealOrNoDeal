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

    public List<Integer> getValues() {
        return values;
    }

    public int getPlayerCaseNumber() {
        return playerCaseNumber;
    }

    public void startGame(){
        Banker banker = new Banker();
        printRules();
        caseSetup(cases, values);
        displayGameBoard();
        Scanner input = new Scanner(System.in);
        System.out.print("Select a case to start the game: ");
        playerCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("You have selected case # " + playerCaseNumber + ".");
        cases[playerCaseNumber-1].setOpen(true);
        promptEnterToUpdateGameBoard(playerCaseNumber);

    }

    public static void printRules(){
        System.out.println("\n\nWelcome to DEAL OR NO DEAL!\n");
        System.out.println("How To Play:\n\t- There are 26 briefcases on the game board.");
        System.out.println("\t- Each case contains a hidden amount of cash inside.");
        System.out.println("\t- Choose your case to start the game. You will not open this case \n" +
                "\t\tuntil the end of the game.");
        System.out.println("\t- Each time you open a case, the cash amount inside will be revealed and \n" +
                "\t\tremoved from the game board.");
        System.out.println("\t- After opening several cases, the Banker will call you with an offer \n" +
                "\t\tto purchase your unopened case.");
        System.out.println("\t- You can accept the offer (DEAL!), or decline and continue playing (NO DEAL!)");
        System.out.println("\t- At the end of the game, we will open up your case and see who got \n" +
                "\t\tthe better deal!");
    }

    public static void caseSetup(Case[] cases, List<Integer> values){
        List<Integer> valuesShuffled = Arrays.asList(1, 2, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000,
                25000, 50000,75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000);;
        Collections.shuffle(valuesShuffled);
        for (int i = 0; i < cases.length; i++){
            cases[i] = new Case(i+1, valuesShuffled.get(i));
        }
    }
    public void displayGameBoard(){
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

    public int selectACase() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Select a case # : ");
        int selectedCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("You have selected case # " + selectedCaseNumber + ".");
        Game.promptEnterToOpen();
        return selectedCaseNumber;
    }

    public static void promptEnterToOpen(){
        System.out.println("\nPress \"ENTER\" to open the case >>>");
        try {
            System.in.read();
        } catch (IOException e){
            e.getMessage();
        }
    }

    public void openCase(int selectedCaseNumber){
        int value = cases[selectedCaseNumber-1].getCaseValue();
        cases[selectedCaseNumber-1].setOpen(true);
        System.out.println("Case # " + selectedCaseNumber + " contains $" + value);
        promptEnterToUpdateGameBoard(selectedCaseNumber);
    }

    public void promptEnterToUpdateGameBoard(int selectedCaseNumber){
        System.out.println("\nPress \"ENTER\" to update the Game Board >>>");
        try {
            System.in.read();
            if (selectedCaseNumber != playerCaseNumber) {
                for (int i = 0; i < values.size(); i++) {
                    if (values.get(i) == cases[selectedCaseNumber - 1].getCaseValue()) {
                        values.set(i, 0);
                    }
                }
            }
            displayGameBoard(cases, values, playerCaseNumber);
        } catch (IOException e){
            e.getMessage();
        }
    }

    public void dealAccepted(int offerPrice){
        System.out.println("\nYou have accepted the Banker's offer for $" + offerPrice);
        System.out.println("Now let's find out how much money was inside your case...");
        promptEnterToOpen();
        int playerCaseValue = cases[playerCaseNumber-1].getCaseValue();
        System.out.println("Case # " + playerCaseNumber + " contains $" + playerCaseValue);
        if (playerCaseValue > offerPrice){
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Whew, looks like you made a good deal!");
        }
        System.out.println("\n Game over. Thanks for playing!");
        System.exit(1);

    }

}