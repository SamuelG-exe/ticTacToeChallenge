package main.ui;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import main.ui.InteractiveUI;



public class Main {
    private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static void main(String[] args) {
        InteractiveUI ui = new InteractiveUI();
        try {
            out.println("X----Welcome to TicTacToe----O");
            ui.runStateMachine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
