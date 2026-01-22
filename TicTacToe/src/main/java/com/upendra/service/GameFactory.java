package com.upendra.service;

import com.upendra.game.Game;
import com.upendra.game.TicTacToeGame;
import com.upendra.model.GameType;

public class GameFactory {

    public static Game createGame(GameType gameType) {
        return switch (gameType) {
            case TicTacToe -> new TicTacToeGame();
            default -> throw new IllegalArgumentException("Unsupported game type: " + gameType);
        };
    }
}
