package main.ui;

import main.game.TicTacToeGame;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InteractiveUI {
    private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    static Scanner scanner = new Scanner(System.in);
    static UserStatus status;
    private static TicTacToeGame game;
    static boolean preGame = true;


    public static void main(String[] args) throws Exception {
        out.println("X----Welcome to TicTacToe----O");
        status = UserStatus.MENU;
        runStateMachine();
    }

    private static void runStateMachine() {

        while (true) {
            runMenuUI();
            runInGameUI();
        }


    }

    private static void runMenuUI() {
        while (status == UserStatus.MENU) {
            while (preGame) {
                out.println();
                out.println();
                out.println("Would you like to play a game of tic tac toe or close the program?");
                out.println("Please enter \"1\" if you would like play a game and \"3\" if you would like to close the program");
                String input = scanner.nextLine().toLowerCase();
                switch (input) {
                    case "1":
                        preGame = false;
                        break;
                    case "3":
                        System.exit(0);
                        break;
                    default:
                        out.println("Sorry I didnt quite understand that, lets try again!");
                        break;
                }
                //prompt
                //grab input
                //change UserStatus or exit program or loop again
            }

        }
    }

    private static void runInGameUI() {
        while (status == UserStatus.INGAME) {
            //prompt
            //grab input
            //change UserStatus or exit program or loop again
        }
    }
}




