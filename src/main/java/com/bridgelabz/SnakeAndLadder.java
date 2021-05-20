package com.bridgelabz;
import java.util.Random;

public class SnakeAndLadder {

    public static final int STARTING_POSITION = 0;
    public static final int NUMBER_OF_PLAYERS = 1;

    public static int rollDice(){
        Random random = new Random();
        int diceValue = random.nextInt(6)+1;
        return diceValue;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Game");
        System.out.println("Dice Number = " +rollDice());
    }
}
