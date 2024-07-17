
import java.util.*;

public class Main {
    public static final String PC = "PC";
    public static final String FRIEND = "Friend";
    public static final String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static Scanner scan = new Scanner(System.in);
    public static String userSign;


    public static void main(String[] args) {
        welcome();
        printBoard();
        placement();
    }

    private static void placement() {
        while (true) {
            System.out.println( userSign + "'s "+ "turn!\nEnter your place between 1 to 9 :");
            int place = scan.nextInt();
            switch (place) {
                case 1 -> board[0] = userSign;
                case 2 -> board[1] = userSign;
                case 3 -> board[2] = userSign;
                case 4 -> board[3] = userSign;
                case 5 -> board[4] = userSign;
                case 6 -> board[5] = userSign;
                case 7 -> board[6] = userSign;
                case 8 -> board[7] = userSign;
                case 9 -> board[8] = userSign;
            }
            printBoard();
            int winCheck = 0;
            String winner = userSign + userSign + userSign;
            String [] winStates = {board[0]+board[1]+board[2],
                    board[3]+board[4]+board[5],
                    board[6]+board[7]+board[8],
                    board[0]+board[3]+board[6],
                    board[1]+board[4]+board[7],
                    board[2]+board[5]+board[8],
                    board[0]+board[4]+board[8],
                    board[2]+board[4]+board[6]};
            for (String winState : winStates) {
                if (winState.equals(winner)) {
                    winCheck = 1;
                    System.out.println("Congratulations! " + userSign + " is winner!");
                }
            }
            if (userSign.equals("X")){
                userSign = "O";
            }
            else userSign = "X";

            if (winCheck == 1)
                break;
        }
    }

    public static void welcome() {
        System.out.println("""
                welcome to the Tic Tac Toe Game!
                you want play with your friend or PC?
                friend : 1
                PC     : 2\s""");
        String userOpponentChoice;
        while (true) {
            int user = scan.nextInt();
            if (user == 1) {
                userOpponentChoice = FRIEND;
                break;
            } else if (user == 2) {
                userOpponentChoice = PC;
                break;
            } else
                System.out.println(" please Enter a number between 1 Or 2 !");
        }
        System.out.println("GOOD!\n" +
                "Do you want to be X or O?");
        userSign = scan.next().toUpperCase();
        System.out.println("You play against " + userOpponentChoice + " as "
                + userSign + "\nGo!");
    }

    private static void printBoard() {

        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }
}