package game;

public class TicTacToeGame {
    private Team turn;


    public Team winner;
    public boolean tie;
    public boolean gameOver;
    public TicTacToeBoard gameboeard;

    //I am using an enum for my own clarity and for consistent reference of team between classes/packages
    public enum Team{
        X,
        O
    }
    TicTacToeGame(boolean botGoesFirst){
        if(botGoesFirst){
            //bot take turn
        }
        gameboeard = new TicTacToeBoard();
        gameOver = false;

    }
        /*
    1)play - need something to call the placing of the board and check legality of move
        i)bottaketurn- either needs to be a call to anotheer class or a function but should happen
            after user's turn
        ii)changeTurn - might not need if I always have the bot go after the player but having it might
        still be a good idea if I wanted to implement 2 player or just to ensure legality of moves
    2)checkGameStatus - I need something to check for game over or tie - might need to add some iter in board


     */


}
