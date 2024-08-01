package main.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void getPiece() {
        TicTacToeBoard testBoard = new TicTacToeBoard();
        String[][] array = testBoard.getArray();
        array[0][0] = "*";
        assertEquals("*", testBoard.getPiece(0, 0));

    }

    @Test
    void resetBoard() {
        TicTacToeBoard testBoard = new TicTacToeBoard();
        testBoard.resetBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals("*", testBoard.getPiece(i, j));
            }
        }

    }


}