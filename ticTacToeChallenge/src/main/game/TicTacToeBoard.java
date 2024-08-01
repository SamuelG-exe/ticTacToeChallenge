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
    1)Reset - for new games and testing - Done
    2)getXorO - need to access the board's individual locations - Done
    3)placeXO - need to be able to set a locations piece to an X or O - Done
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


    public String getPiece(XOPosition position){
        return gameBoard[position.getRow()][position.getCol()];
    }


    //Upon starting this function I realized I wanted a position class/Possible Record as it improves code comprehension and should help mitigate out of bounds errors.
    public void placeXO(XOPosition position, TicTacToeGame.Team team){
        if(team == TicTacToeGame.Team.X) {
            gameBoard[position.getRow()][position.getCol()] = "X";
        }
        else{
            gameBoard[position.getRow()][position.getCol()] = "O";
        }
    }

}
