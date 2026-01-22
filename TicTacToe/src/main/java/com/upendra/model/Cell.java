package com.upendra.model;

public record Cell(PieceSymbol pieceSymbol) {

    @Override
    public String toString() {
        return this.pieceSymbol.toString();
    }
}
