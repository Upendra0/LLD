package com.upendra;

import com.upendra.model.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TicTacToeGame {
    private final List<Player> players;
    private final TicTacToeBoard gameBoard;
    private int currentPlayerPosition;

    public TicTacToeGame() {
        this.players = List.of(
                new Player("Player1", new PlayingPieceX()),
                new Player("Player2", new PlayingPieceO())
        );
        this.gameBoard = new TicTacToeBoard(3);
        this.currentPlayerPosition = 0;
    }

    public Optional<Player> startGame() {
        Scanner scanner = new Scanner(System.in);

        while (gameBoard.hasAnyPositionAvailable()) {
            displayBoard();
            Player playerTurn = players.get(currentPlayerPosition);

            if (!makeMove(scanner, playerTurn)) {
                continue;
            }

            if (checkWinner(playerTurn)) {
                return Optional.of(playerTurn);
            }
        }
        scanner.close();
        return Optional.empty();
    }

    private void displayBoard() {
        System.out.printf("%nCurrent Board%n");
        System.out.println(gameBoard);
    }

    private boolean makeMove(Scanner scanner, Player playerTurn) {
        System.out.printf("%s, enter your move (row col): ", playerTurn.getName());
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (!gameBoard.setCellIfEmpty(row, col, playerTurn.getPlayingPiece().getPiece())) {
            System.out.println("Incorrect Position chosen. Try again.");
            return false;
        }
        currentPlayerPosition = (currentPlayerPosition + 1) % players.size();
        return true;
    }

    private boolean checkWinner(Player playerTurn) {
        Piece piece = playerTurn.getPlayingPiece().getPiece();
        return isRowWin(piece) || isColWin(piece) || isDiagonalWin(piece);
    }

    private boolean isRowWin(Piece piece) {
        for (int row = 0; row < gameBoard.size(); row++) {
            boolean win = true;
            for (int col = 0; col < gameBoard.size(); col++) {
                if (gameBoard.getCellValue(row, col) != piece) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean isColWin(Piece piece) {
        for (int col = 0; col < gameBoard.size(); col++) {
            boolean win = true;
            for (int row = 0; row < gameBoard.size(); row++) {
                if (gameBoard.getCellValue(row, col) != piece) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean isDiagonalWin(Piece piece) {
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;
        for (int i = 0; i < gameBoard.size(); i++) {
            if (gameBoard.getCellValue(i, i) != piece) {
                leftDiagonal = false;
            }
            if (gameBoard.getCellValue(i, gameBoard.size() - i - 1) != piece) {
                rightDiagonal = false;
            }
        }
        return leftDiagonal || rightDiagonal;
    }
}
