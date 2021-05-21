package com.bridgelabz;
import java.util.Random;

public class SnakeAndLadder {

    public static final int STARTING_POSITION = 0;
    public static final int NUMBER_OF_PLAYERS = 1;
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    //initialized the user position with start position
    static int PLAYER_POSITION = STARTING_POSITION;
    public static final int WIN_POSITION = 100;

    // method to get the value of dice between 1 to 6
    public static int rollDice(){
        Random random = new Random();
        int diceValue = random.nextInt(6)+1;
        return diceValue;
    }

    // method to get the value of moves
    public static int moves(){
        Random random = new Random();
        int moveValue = random.nextInt(3);
        return moveValue;
    }

    //Method to set the position of the player
    public static void setPlayerPosition(int playerPosition) {
        SnakeAndLadder.PLAYER_POSITION = playerPosition;
    }

    //Method to get the position of the player
    public static int getPlayerPosition() {
        return PLAYER_POSITION;
    }

    public static void main(String[] args) {

        while (getPlayerPosition() != WIN_POSITION) {

            int numberOnDice = rollDice();
            int playerMove = moves();

            if(getPlayerPosition() < 1) {
                setPlayerPosition(STARTING_POSITION);
            }
            if (playerMove == NO_PLAY) {
                setPlayerPosition(getPlayerPosition());
            }
            else if (playerMove == LADDER) {
                if (getPlayerPosition() + numberOnDice > WIN_POSITION) {
                    setPlayerPosition(getPlayerPosition());
                } else {
                    setPlayerPosition(getPlayerPosition() + numberOnDice);
                }
            }
            else if (playerMove == SNAKE) {
                setPlayerPosition(getPlayerPosition() - numberOnDice);
            }
            System.out.println(getPlayerPosition());
        }
    }
}
