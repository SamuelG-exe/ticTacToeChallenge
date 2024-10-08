package main.ui;

import main.game.TicTacToeGame;
import main.game.XOPosition;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static main.ui.DrawBoard.drawboard;

public class InteractiveUI {
    private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    static Scanner scanner = new Scanner(System.in);
    static UserStatus status = UserStatus.MENU;
    private static TicTacToeGame game;
    static boolean preGame = true;



    public void runStateMachine() throws Exception {
        while (true) {
            runMenuUI();
            drawboard(game.gameBoard);
            runInGameUI();
        }
    }

    private static void runMenuUI() throws Exception {
        while (status == UserStatus.MENU) {
            while (preGame) {
                out.println();
                out.println();
                out.println("Would you like to play a game of tic tac toe or close the program?");
                out.println("Please enter \"1\" if you would like play a game and \"3\" if you would like to close the program");
                String input = scanner.nextLine().toLowerCase();
                switch (input) {
                    case "1", "one":
                        preGame = false;
                        break;
                    case "3", "three":
                        System.exit(0);
                        break;
                    default:
                        out.println("Sorry I didnt quite understand that, lets try again!");
                        break;
                }
            }
            out.println("Would you like to go first or the computer?");
            out.println("Please enter \"1\" if you would like to go first and \"2\" if you would like the computer to go first and \"3\" if you would like to close the program");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "1": {
                    game = new TicTacToeGame(false);
                    status = UserStatus.INGAME;
                    break;
                }
                case "2": {
                    game = new TicTacToeGame(true);
                    status = UserStatus.INGAME;
                    break;
                }
                case "3":
                    System.exit(0);
                    break;
                default:
                    out.println("Sorry I didnt quite understand that, lets try again!");
                    break;
            }

        }
    }

    private static void runInGameUI() {
        while (status == UserStatus.INGAME) {
            out.println("Would box would you like to play in");
            out.println("Please enter a number from 1-9 with 1, 2, and 3 being the top row from left to right");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "1" : {
                    makePlay(0,0);
                    drawboard(game.gameBoard);
                    break;
                }
                case "2" : {
                    makePlay(0, 1);
                    drawboard(game.gameBoard);
                    break;
                }
                case "3" : {
                    makePlay(0, 2);
                    drawboard(game.gameBoard);
                    break;
                }
                case "4" : {
                    makePlay(1, 0);
                    drawboard(game.gameBoard);
                    break;
                }
                case "5" : {
                    makePlay(1, 1);
                    drawboard(game.gameBoard);
                    break;
                }
                case "6" : {
                    makePlay(1, 2);
                    drawboard(game.gameBoard);
                    break;
                }
                case "7" : {
                    makePlay(2, 0);
                    drawboard(game.gameBoard);
                    break;
                }
                case "8" : {
                    makePlay(2, 1);
                    drawboard(game.gameBoard);
                    break;
                }
                case "9" : {
                    makePlay(2, 2);
                    drawboard(game.gameBoard);
                    break;
                }

                }
            }
        }

    private static void makePlay(int row, int col) {
        try {
            game.play(new XOPosition(row, col));
        } catch (Exception e) {
            out.println(e.getMessage());
            if (game.gameOver) {
                status = UserStatus.MENU;
                preGame = true;
            }
        }
    }

}




