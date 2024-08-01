package main.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {

    @Test
    void play() {
        TicTacToeGame game = new TicTacToeGame(false);
        XOPosition newPos = new XOPosition(0, 0);
        game.gameOver = true;

        assertThrows(Exception.class, () -> {
            game.play(newPos);

        });
    }
}