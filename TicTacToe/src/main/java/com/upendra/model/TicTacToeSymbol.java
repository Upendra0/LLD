package com.upendra.model;

public enum TicTacToeSymbol implements Symbol {
   X, O;

    @Override
    public String getSymbol() {
        return name();
    }
}
