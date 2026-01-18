package com.upendra.model;

public class Cell {
    private final Symbol symbol;

    public Cell(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return this.symbol.toString();
    }
}
