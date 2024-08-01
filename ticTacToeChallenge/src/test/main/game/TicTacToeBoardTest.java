package main.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void getPiece() {
        TicTacToeBoard testBoard = new TicTacToeBoard();
        String[][] array = testBoard.getArray();
        array[0][0] = "*";
        XOPosition testLocal = new XOPosition(0 , 0);
        assertEquals("*", testBoard.getPiece(testLocal));

    }

    @Test
    void resetBoard() {
        TicTacToeBoard testBoard = new TicTacToeBoard();
        testBoard.resetBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                XOPosition testLocal = new XOPosition(i , j);
                assertEquals("*", testBoard.getPiece(testLocal));
            }
        }

    }


    @Test
    void placeXO() {
        TicTacToeBoard testBoard = new TicTacToeBoard();
        XOPosition testLocal = new XOPosition(0 , 0);
        testBoard.placeXO(testLocal, TicTacToeGame.Team.X);
        assertEquals("X", testBoard.getPiece(testLocal));
    }
}