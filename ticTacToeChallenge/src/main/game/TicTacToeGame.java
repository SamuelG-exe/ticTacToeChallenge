package main.game;

import java.util.Objects;
import java.util.Vector;

public class TicTacToeGame {
    private Team turn;


    public Team winner;
    public boolean tie;
    public boolean gameOver;
    public TicTacToeBoard gameBoard;

    //I am using an enum for my own clarity and for consistent reference of team between classes/packages

    public enum Team{
        X,
        O
    }

    /**
     * @param botGoesFirst
     */
    TicTacToeGame(boolean botGoesFirst){
        if(botGoesFirst){
            //bot take turn
        }
        gameBoard = new TicTacToeBoard();
        gameOver = false;

    }
        /*
    1)play - need something to call the placing of the board and check legality of move
        i)bottaketurn- either needs to be a call to anotheer class or a function but should happen
            after user's turn
        ii)changeTurn - might not need if I always have the bot go after the player but having it might - done
        still be a good idea if I wanted to implement 2 player or just to ensure legality of moves
    2)checkGameStatus - I need something to check for game over or tie - might need to add some iter in board
     */

    /**
     *
     * @param position
     * @throws Exception
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
        } else if (!Objects.equals(gameBoard.getPiece(position), "*")) {                                   //Checks for empty space
            throw new Exception("You have to play on an empty square");                                                         //throws error if not empty, will use this to output in UI
        }
        else {
            gameBoard.placeXO(position, turn);
            checkGameStatus();
            nextPlayersTurn();
        }
    }

    private void botPlay() throws Exception {}

    private void checkGameStatus(){}

    private void nextPlayersTurn(){
        if (turn == Team.X){turn = Team.O;}
        else{turn = Team.X;}
    }


}
