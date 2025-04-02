package com.upendra.model;

public class Player {

    private final String name;
    private final PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playingPiece=" + playingPiece +
                '}';
    }
}
