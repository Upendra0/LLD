package com.upendra.model;

public class Player {

    private final String name;
    private final PieceSymbol pieceSymbol;

    public Player(String name, PieceSymbol playingPieceSymbol) {
        this.name = name;
        this.pieceSymbol = playingPieceSymbol;
    }

    public String getName() {
        return name;
    }

    public PieceSymbol getSymbol() {
        return this.pieceSymbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ",symbol=" + this.pieceSymbol +
                '}';
    }
}
