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
        out.println("----Welcome to TicTacToe----");
        status = UserStatus.MENU;
        runStateMachine();
    }

    private static void runStateMachine() {

        while (true){
            runMenuUI();
            runInGameUI();
        }


    }

    private static void runInGameUI() {
        while (status == UserStatus.INGAME){
            //prompt
            //grab input
            //change UserStatus or exit program
        }
    }

    private static void runMenuUI() {
        while(status == UserStatus.MENU){
            //prompt
            //grab input
            //change pregame or exit
            while(preGame){
                //prompt
                //grab input
                //change UserStatus or exit

            }
        }
    }


}
