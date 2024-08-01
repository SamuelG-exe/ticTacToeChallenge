package main.game;

import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class TicTacToeBoard {

    private String[][] gameBoard;

    /**
     * Constructs a new TicTacToeBoard instance and initializes the board.
     */
    public TicTacToeBoard() {
        gameBoard = new String[3][3];
    }

    /**
     * This method is intended for testing purposes only.
     *
     * @return the internal game board array
     */
    public String[][] getArray() {
        return this.gameBoard;
    }

    /**
     * Resets the game board and fills all positions with "*".
     */
    public void resetBoard() {
        for (String[] strings : gameBoard) {
            Arrays.fill(strings, "*");
        }
    }

    /**
     * Retrieves the piece at the specified position on the board.
     *
     * @param position the position to retrieve the piece from
     * @return the piece at the specified position
     */
    public String getPiece(XOPosition position) {
        return gameBoard[position.getRow()][position.getCol()];
    }

    /**
     * Places an X or O on the board at the specified position.
     *
     * @param position the position to place the piece
     * @param team     the team (X or O) placing the piece
     */
    public void placeXO(XOPosition position, TicTacToeGame.Team team) {
        if (team == TicTacToeGame.Team.X) {
            gameBoard[position.getRow()][position.getCol()] = "X";
        } else {
            gameBoard[position.getRow()][position.getCol()] = "O";
        }
    }

    /**
     * Checks if the board is full (i.e., no more empty spaces).
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isBoardFull() {
        for (String[] row : gameBoard) {
            for (String cell : row) {
                if (cell.equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if there are three pieces in a row for the specified team.
     *
     * @param team the team (X or O) to check for
     * @return true if there are three pieces in a row, false otherwise
     */
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

    /**
     * Checks each row for three pieces in a row for the specified team.
     *
     * @param team the team (X or O) to check for
     * @return true if there are three pieces in a row in any row, false otherwise
     */
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

    /**
     * Checks each column for three pieces in a row for the specified team.
     *
     * @param team the team (X or O) to check for
     * @return true if there are three pieces in a row in any column, false otherwise
     */
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

    /**
     * Checks both diagonals for three pieces in a row for the specified team.
     *
     * @param team the team (X or O) to check for
     * @return true if there are three pieces in a row in either diagonal, false otherwise
     */
    private boolean diagonalChecker(String team) {
        return diagonalCheckerRight(team) || diagonalCheckerLeft(team);
    }

    /**
     * Checks the top-left to bottom-right diagonal for three pieces in a row for the specified team.
     *
     * @param team the team (X or O) to check for
     * @return true if there are three pieces in a row in the diagonal, false otherwise
     */
    private boolean diagonalCheckerRight(String team) {
        return Objects.equals(gameBoard[0][0], team) &&
                Objects.equals(gameBoard[0][0], gameBoard[1][1]) &&
                Objects.equals(gameBoard[1][1], gameBoard[2][2]);
    }

    /**
     * Checks the top-right to bottom-left diagonal for three pieces in a row for the specified team.
     *
     * @param team the team (X or O) to check for
     * @return true if there are three pieces in a row in the diagonal, false otherwise
     */
    private boolean diagonalCheckerLeft(String team) {
        return Objects.equals(gameBoard[0][2], team) &&
                Objects.equals(gameBoard[0][2], gameBoard[1][1]) &&
                Objects.equals(gameBoard[1][1], gameBoard[2][0]);
    }

    /**
     * Retrieves a list of all valid play locations (empty positions) on the board.
     *
     * @return a vector of valid play locations
     */
    public Vector<XOPosition> validPlayLocations() {
        Vector<XOPosition> validPlays = new Vector<>();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j].equals("*")) {
                    validPlays.add(new XOPosition(i, j));
                }
            }
        }
        return validPlays;
    }
}