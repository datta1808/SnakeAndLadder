package com.bridgelabz;
import java.util.Random;

public class SnakeAndLadder {

    public static final int STARTING_POSITION = 0;
    public static final int WIN_POSITION = 100;
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    static String TASK;
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

    public int gamePlay(int currentPosition, int diceCount) {
        if(currentPosition < WIN_POSITION) {
            int diceNumber = rollDice();
            int playerMove = moves();

            switch (playerMove) {
                case NO_PLAY:
                    currentPosition = currentPosition;
                    TASK = "noPlay";
                    break;
                case LADDER:
                    if(currentPosition + diceNumber <= WIN_POSITION)
                    {
                        currentPosition = currentPosition + diceNumber;
                        TASK = "Ladder";
                    }
                    break;
                case SNAKE:
                    if(currentPosition - diceNumber >= STARTING_POSITION)
                    {
                        currentPosition = currentPosition - diceNumber;
                        TASK = "Snake";
                    }
                    break;
        }
            System.out.println("Dice : "+ diceNumber +" for "+ TASK +" and Current Position : "+ currentPosition+"");
    }
        if(TASK == "Ladder" && currentPosition != WIN_POSITION)
        {
            diceCount = dice_Player(diceCount);
            gamePlay(currentPosition, diceCount);
        }
        return currentPosition;
    }
    // Dice count increment after every rolling dice
    public int dice_Player(int diceCount)
    {
        diceCount++;
        return diceCount;
    }

    // Game played by two players
    public void TwoPlayers()
    {
        int Player1position = STARTING_POSITION ;
        int Player2position = STARTING_POSITION ;
        int dice_count = 0 ;
        System.out.println("Game Started by two player");
        while( Player1position < WIN_POSITION && Player2position < WIN_POSITION )
        {
            System.out.println("Player 1 :-  ");
            Player1position = gamePlay(Player1position, dice_count);
            dice_count = dice_Player(dice_count);
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            if(Player1position == WIN_POSITION)
            {
                break;
            }
            System.out.println("Player 2 :-  ");
            Player2position = gamePlay(Player2position,dice_count);
            dice_count = dice_Player(dice_count);
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
        if(Player1position == WIN_POSITION)
        {
            System.out.println();
            System.out.println("Player 1 Won The Match ");
        }
        else if(Player2position == WIN_POSITION)
        {
            System.out.println();
            System.out.println("Player 2 Won The Match ");
        }
        System.out.println("Total Dice Count of both Players "+dice_count);
    }
    public static void main(String args[])
    {   System.out.println("Welcome to snake and ladder game simulator");
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        snakeAndLadder.TwoPlayers();

    }
}