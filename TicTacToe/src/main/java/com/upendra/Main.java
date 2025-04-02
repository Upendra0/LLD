package com.upendra;

import com.upendra.model.Player;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame newGame = new TicTacToeGame();
        Optional<Player> gameResult = newGame.startGame();
        if(gameResult.isEmpty()){
            System.out.println("Game is Tied");
        } else {
            System.out.println("Game won by " + gameResult.get());
        }
    }
}