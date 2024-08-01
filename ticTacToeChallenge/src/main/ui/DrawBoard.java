package main.ui;

import main.game.TicTacToeBoard;
import main.game.XOPosition;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class DrawBoard {
    static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);


    public static void drawboard(TicTacToeBoard board){
        out.println();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                XOPosition newLocation = new XOPosition(i, j);
                if(j == 2 ){                                            //    This Line is meant to ensure that when printing it is in rows of 3.
                    out.println(board.getPiece(newLocation));
                }
                else {
                    out.print(board.getPiece(newLocation)+" ");
                }

            }
        }

    }
}
