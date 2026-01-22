package com.upendra.model;

public enum TicTacToePieceSymbol implements PieceSymbol {
   X, O;

    @Override
    public String getSymbol() {
        return name();
    }
}
