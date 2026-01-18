package com.upendra.model;

public class Player {

    private final String name;
    private final Symbol symbol;

    public Player(String name, Symbol playingSymbol) {
        this.name = name;
        this.symbol = playingSymbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ",symbol=" + this.symbol +
                '}';
    }
}
