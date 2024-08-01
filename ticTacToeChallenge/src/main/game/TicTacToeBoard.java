package main.game;

import java.util.Arrays;
import java.util.Objects;

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
    4)checkFor3InARow - need to report 3 in a row
    5)CheckforNomorePlays - is the board full
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

    public boolean isBoardFull() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j].equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean threeInARow(TicTacToeGame.Team team){
        String stringOfTeam;
        if(team == TicTacToeGame.Team.X) {
            stringOfTeam = "X";
        }
        else {
            stringOfTeam = "O";
        }
        return rowChecker(stringOfTeam) || colChecker(stringOfTeam) || diagonalChecker(stringOfTeam);
    }
    private boolean rowChecker(String team) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (Objects.equals(gameBoard[i][0], team) &&
                    Objects.equals(gameBoard[i][0], gameBoard[i][1]) &&
                    Objects.equals(gameBoard[i][1], gameBoard[i][2])) {
                return true;
            }
        }
        return false;
    }
    private boolean colChecker(String team) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (Objects.equals(gameBoard[0][i], team) &&
                    Objects.equals(gameBoard[0][i], gameBoard[1][i]) &&
                    Objects.equals(gameBoard[1][i], gameBoard[2][i])) {
                return true;
            }
        }
        return false;
    }
    private boolean diagonalChecker(String team) {
        return diagonalCheckerRight(team) || diagonalCheckerLeft(team);
    }
    private boolean diagonalCheckerRight(String team) {
        return  Objects.equals(gameBoard[0][0], team) &&
                Objects.equals(gameBoard[0][0], gameBoard[1][1]) &&
                Objects.equals(gameBoard[1][1], gameBoard[2][2]);
    }
    private boolean diagonalCheckerLeft(String team) {
        return  Objects.equals(gameBoard[0][2], team) &&
                Objects.equals(gameBoard[0][2], gameBoard[1][1]) &&
                Objects.equals(gameBoard[1][1], gameBoard[2][0]);
    }
}
