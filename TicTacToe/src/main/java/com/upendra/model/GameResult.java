package com.upendra.model;

import java.util.Optional;

public class GameResult {

    private final GameState gameState;
    private final Player winner;

    public GameResult(GameState gameState, Player winner) {
        this.gameState = gameState;
        this.winner = winner;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Optional<Player> getWinner() {
        return Optional.ofNullable(this.winner);
    }
}
