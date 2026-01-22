package com.upendra.app;

import com.upendra.service.GameFactory;
import com.upendra.game.Game;
import com.upendra.model.GameResult;
import com.upendra.model.GameType;

public class Main {
    public static void main(String[] args) {
        Game newGame = GameFactory.createGame(GameType.TicTacToe);
        GameResult gameResult = newGame.startGame();
        switch (gameResult.getGameState()) {
            case DRAW -> System.out.println("The game ended in a draw.");
            case WIN -> System.out.println("The winner is: " + gameResult.getWinner().orElseThrow().getName());
            case IN_PROGRESS -> System.out.println("The game is still in progress.");
        }
    }
}