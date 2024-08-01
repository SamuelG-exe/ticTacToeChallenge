package main.game;

import java.util.Arrays;

public class TicTacToeBoard {

    //could use int or Char but String will give me a bit more freedom as I develop
    private String[][] gameBoard;

    TicTacToeBoard(){
        gameBoard = new String[3][3];
    }

    /*
    I need a few functions for sure
    1)Reset - for new games and testing
    2)getXorO - need to access the board's individual locations
    3)placeXO - need to be able to set a locations piece to an X or O
     */

    //for testing ONLY
    public String[][] getArray(){
        return this.gameBoard;
    }


    public void resetBoard(){
        for (String[] strings : gameBoard) {
            Arrays.fill(strings, "*");
        }
    }
    public String getPiece(int row, int col){
        return gameBoard[row][col];
    }

}
