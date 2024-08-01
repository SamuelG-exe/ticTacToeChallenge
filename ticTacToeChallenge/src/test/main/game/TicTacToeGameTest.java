package main.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {

    @Test
    void testPlayAfterGame() throws Exception {
        TicTacToeGame game = new TicTacToeGame(false);
        XOPosition newPos = new XOPosition(0, 0);
        game.gameOver = true;

        assertThrows(Exception.class, () -> {
            game.play(newPos);

        });
    }
    @Test
    void testPlayOverwrite() throws Exception {
        TicTacToeGame game = new TicTacToeGame(false);
        XOPosition newPos = new XOPosition(0, 0);
        game.play(newPos);

        assertThrows(Exception.class, () -> {
            game.play(newPos);

        });
    }

    @Test
    void testPlayValid() throws Exception {
        TicTacToeGame game = new TicTacToeGame(false);
        XOPosition newPos = new XOPosition(0, 0);
        game.play(newPos);
        assertEquals("X", game.gameBoard.getPiece(newPos));
    }

    @Test
    void testPlayXWin() throws Exception {//need to finish after bot play implementation
        TicTacToeGame game = new TicTacToeGame(false);
        XOPosition newPos = new XOPosition(0, 2);
        game.gameBoard.getArray()[0][0] = "X";
        game.gameBoard.getArray()[0][1] = "X";

        assertThrows(Exception.class, () -> {
            game.play(newPos);

        });
        assertEquals(TicTacToeGame.Team.X, game.winner);
    }

    @Test
    void testTieGame() throws Exception {//need to finish after bot play implementation
        TicTacToeGame game = new TicTacToeGame(false);
        XOPosition newPos = new XOPosition(2, 2);
        game.gameBoard.getArray()[0][0] = "0";
        game.gameBoard.getArray()[0][1] = "X";
        game.gameBoard.getArray()[0][2] = "0";

        game.gameBoard.getArray()[1][0] = "X";
        game.gameBoard.getArray()[1][1] = "X";
        game.gameBoard.getArray()[1][2] = "O";

        game.gameBoard.getArray()[2][0] = "X";
        game.gameBoard.getArray()[2][1] = "O";



        assertThrows(Exception.class, () -> {
            game.play(newPos);

        });
        assertTrue(game.tie);
    }

}