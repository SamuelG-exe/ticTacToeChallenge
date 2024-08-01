package main.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {

    @Test
    void testPlayAfterGame() {
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

}