package main.game;

import java.util.Objects;
import java.util.Vector;

public class TicTacToeGame {
    private Team turn;
    public Team winner;
    public boolean tie;
    public boolean gameOver;
    public TicTacToeBoard gameBoard;

    public enum Team {
        X,
        O
    }

    /**
     * Constructs a new TicTacToeGame instance and initializes the game board.
     * If botGoesFirst is true, the bot (Team O) makes the first move.
     *
     * @param botGoesFirst boolean indicating if the bot should make the first move
     * @throws Exception if an error occurs during the bot's play
     */
    TicTacToeGame(boolean botGoesFirst) throws Exception {
        gameBoard = new TicTacToeBoard();
        gameBoard.resetBoard();
        gameOver = false;
        if (botGoesFirst) {
            this.turn = Team.O;
            botPlay();
        } else {
            this.turn = Team.X;
        }
    }

    /**
     * Allows the player to make a move at the provided position.
     * Checks the game status after the move and may trigger the bot's play.
     *
     * @param position the position where the player wants to place their piece
     * @throws Exception if the game is over or the position is already occupied
     */
    public void play(XOPosition position) throws Exception {
        if (gameOver) {
            String gameOverNotification;
            if (tie) {
                gameOverNotification = " It was a TIE!";
            } else {
                gameOverNotification = "The Winner was: " + winner;
            }
            throw new Exception("Game is Over!" + gameOverNotification);
        } else if (!Objects.equals(gameBoard.getPiece(position), "*")) {
            throw new Exception("You have to play on an empty square");
        } else {
            gameBoard.placeXO(position, turn);
            checkGameStatus();
            if (turn == Team.X) {
                nextPlayersTurn();
                botPlay();
            } else {
                nextPlayersTurn();
            }
        }
    }

    /**
     * Makes a move for the bot by picking a random valid play from the vector.
     *
     * @throws Exception if an error occurs during the bot's play
     */
    private void botPlay() throws Exception {
        Vector<XOPosition> validPlays = gameBoard.validPlayLocations();
        int index = (int)(Math.random() * validPlays.size());
        play(validPlays.get(index));
    }

    /**
     * Checks the current game status to determine if there's a winner or a tie.
     * Updates the status accordingly
     */
    private void checkGameStatus() {
        if (gameBoard.threeInARow(turn)) {
            gameOver = true;
            tie = false;
            winner = turn;
        } else if (gameBoard.isBoardFull()) {
            gameOver = true;
            tie = true;
        }
    }

    /**
     * Switches the turn to the next player.
     */
    private void nextPlayersTurn() {
        if (turn == Team.X) {
            turn = Team.O;
        } else {
            turn = Team.X;
        }
    }
}