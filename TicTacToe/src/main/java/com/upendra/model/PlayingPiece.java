package com.upendra.model;

public class PlayingPiece {

    private final Piece piece;

    public PlayingPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "PlayingPiece{" +
                "piece=" + piece +
                '}';
    }
}
