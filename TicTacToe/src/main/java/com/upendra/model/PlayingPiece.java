package com.upendra.model;

public class PlayingPiece {

    private final Cell cell;

    public PlayingPiece(Cell cell) {
        this.cell = cell;
    }

    public Cell getPiece() {
        return cell;
    }

    @Override
    public String toString() {
        return "PlayingPiece{" +
                "piece=" + cell +
                '}';
    }
}
