import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000,
                25000, 50000,75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000);

        Case[] cases = new Case[26];
        caseSetup(cases);

        displayGameBoard(cases, values);
        Scanner input = new Scanner(System.in);
        System.out.printf("Select a case. Enter desired case number: ");
        int playerCaseNumber = Integer.parseInt(input.nextLine());
        System.out.println("You have selected case # " + playerCaseNumber + ".");
        promptEnterToOpen();
        int playerCaseValue = cases[playerCaseNumber - 1].getCaseValue();
        System.out.println("Case # " + playerCaseNumber + " contains $" + playerCaseValue + ".");
        promptEnterToUpdateGameBoard(cases, values, playerCaseNumber, playerCaseValue);
        System.out.printf("\n%-61s%-15s","Your Case #: " + playerCaseNumber, "Your Case Contains: $" + playerCaseValue);
        System.out.println("\n--------------------------------------------------------------------------------------");


    }

    public static void caseSetup(Case[] cases){
        List<Integer> values = Arrays.asList(1, 2, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000,
                25000, 50000,75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000);
        Collections.shuffle(values);
        for (int i = 0; i < cases.length; i++){
            cases[i] = new Case(i+1, values.get(i));

        }
    }

    public static void displayGameBoard(Case[] cases, List<Integer> values){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("                         DEAL OR NO DEAL: CURRENT BOARD                               ");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayCaseValue(values.get(0)), cases[0].getDisplay(), cases[1].getDisplay(),
                cases[2].getDisplay(), cases[3].getDisplay(), cases[4].getDisplay(),displayCaseValue(values.get(13)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(1)), displayCaseValue(values.get(14)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayCaseValue(values.get(2)), cases[5].getDisplay(), cases[6].getDisplay(),
                cases[7].getDisplay(), cases[8].getDisplay(), cases[9].getDisplay(),displayCaseValue(values.get(15)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(3)), displayCaseValue(values.get(16)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayCaseValue(values.get(4)), cases[10].getDisplay(), cases[11].getDisplay(),
                cases[12].getDisplay(), cases[13].getDisplay(), cases[14].getDisplay(),displayCaseValue(values.get(17)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(5)), displayCaseValue(values.get(18)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayCaseValue(values.get(6)), cases[15].getDisplay(), cases[16].getDisplay(),
                cases[17].getDisplay(), cases[18].getDisplay(), cases[19].getDisplay(),displayCaseValue(values.get(19)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(7)), displayCaseValue(values.get(20)));
        System.out.printf("\n$%-25s%-6s%-6s%-6s%-6s%-25s$%-15s", displayCaseValue(values.get(8)), cases[20].getDisplay(), cases[21].getDisplay(),
                cases[22].getDisplay(), cases[23].getDisplay(), cases[24].getDisplay(),displayCaseValue(values.get(21)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(9)), displayCaseValue(values.get(22)));
        System.out.printf("\n$%-37s%-37s$%-15s", displayCaseValue(values.get(10)), cases[25].getDisplay(), displayCaseValue(values.get(23)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(11)), displayCaseValue(values.get(24)));
        System.out.printf("\n$%-74s$%-15s", displayCaseValue(values.get(12)), displayCaseValue(values.get(25)));
        System.out.println("\n--------------------------------------------------------------------------------------");
    }

    public static void promptEnterToOpen(){
        System.out.println("Press \"ENTER\" to open the case.");
        try {
            System.in.read();
        } catch (IOException e){
            e.getMessage();
        }
    }
    public static void promptEnterToUpdateGameBoard(Case[] cases, List<Integer> values,
                                                    int selectedCaseNumber, int selectedCaseValue){
        System.out.println("Press \"ENTER\" to update the Game Board.");
        try {
            System.in.read();
            cases[selectedCaseNumber - 1].setOpen(true);
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) == selectedCaseValue) {
                 values.set(i, 0);
                }
            }
            displayGameBoard(cases, values);
        } catch (IOException e){
            e.getMessage();
        }
    }
    public static String displayCaseValue(int caseValue){
        String displayValue = Integer.toString(caseValue);
        if (displayValue.equals("0")) {
            displayValue = "------";
        }
        return displayValue;
    }

}
