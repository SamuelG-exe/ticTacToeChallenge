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

    @Test
    void testThreeInARowX() throws Exception {//need to finish after bot play implementation
        TicTacToeGame game = new TicTacToeGame(false);

        game.gameBoard.getArray()[0][0] = "X";
        game.gameBoard.getArray()[0][1] = "X";
        game.gameBoard.getArray()[0][2] = "X";


        assertTrue(game.gameBoard.threeInARow(TicTacToeGame.Team.X));
    }

    @Test
    void testThreeInARowO() throws Exception {//need to finish after bot play implementation
        TicTacToeGame game = new TicTacToeGame(false);

        game.gameBoard.getArray()[0][0] = "O";
        game.gameBoard.getArray()[0][1] = "O";
        game.gameBoard.getArray()[0][2] = "O";


        assertTrue(game.gameBoard.threeInARow(TicTacToeGame.Team.O));
    }

    @Test
    void testThreeInARowXDiagnal() throws Exception {//need to finish after bot play implementation
        TicTacToeGame game = new TicTacToeGame(false);

        game.gameBoard.getArray()[0][0] = "X";
        game.gameBoard.getArray()[1][1] = "X";
        game.gameBoard.getArray()[2][2] = "X";


        assertTrue(game.gameBoard.threeInARow(TicTacToeGame.Team.X));
    }

    @Test
    void testThreeInARowODiagnal() throws Exception {//need to finish after bot play implementation
        TicTacToeGame game = new TicTacToeGame(false);

        game.gameBoard.getArray()[0][0] = "O";
        game.gameBoard.getArray()[1][1] = "O";
        game.gameBoard.getArray()[2][2] = "O";


        assertTrue(game.gameBoard.threeInARow(TicTacToeGame.Team.O));
    }


}