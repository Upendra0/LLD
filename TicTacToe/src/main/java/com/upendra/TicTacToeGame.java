package com.upendra;

import com.upendra.model.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TicTacToeGame {
    private final List<Player> players;
    private final Board gameBoard;
    private int currentPlayerPosition;
    int boardSize = 3;

    public TicTacToeGame() {
        this.players = List.of(
                new Player("Player1", TicTacToeSymbol.X),
                new Player("Player2", TicTacToeSymbol.O)
        );
        this.gameBoard = new TicTacToeBoard(boardSize, boardSize);
        this.currentPlayerPosition = 0;
    }

    public Optional<Player> startGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (isAnyPositionAvailable(gameBoard)) {
                displayBoard();
                Player playerTurn = players.get(currentPlayerPosition);

                if (!makeMove(scanner, playerTurn)) {
                    continue;
                }

                if (checkWinner(playerTurn)) {
                    displayBoard();
                    return Optional.of(playerTurn);
                }
            }
            displayBoard();
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isAnyPositionAvailable(Board gameBoard) {
        for (int i = 0; i < gameBoard.getRow(); i++) {
            for (int j = 0; j < gameBoard.getCol(); j++) {
                if (gameBoard.isCellEmpty(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void displayBoard() {
        System.out.printf("%nCurrent Board%n");
        System.out.println(gameBoard);
    }

    private boolean makeMove(Scanner scanner, Player playerTurn) {
        System.out.printf("%s, enter your move (row col): ", playerTurn.getName());
        int row, col;
        try {
            row = scanner.nextInt();
            col = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter two integers.");
            scanner.nextLine(); // clear invalid input
            return false;
        }
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            System.out.println("Position out of bounds. Try again.");
            return false;
        }
        if (!gameBoard.isCellEmpty(row, col)) {
            System.out.println("Incorrect Position chosen. Try again.");
            return false;
        }
        gameBoard.setCell(row, col, new Cell(playerTurn.getSymbol()));
        currentPlayerPosition = (currentPlayerPosition + 1) % players.size();
        return true;
    }

    private boolean checkWinner(Player playerTurn) {
        Symbol symbol = playerTurn.getSymbol();
        return isRowWin(symbol) || isColWin(symbol) || isDiagonalWin(symbol);
    }

    private boolean isRowWin(Symbol symbol) {
        for (int row = 0; row < gameBoard.getRow(); row++) {
            boolean win = true;
            for (int col = 0; col < gameBoard.getCol(); col++) {
                Cell cell = gameBoard.getCell(row, col);
                if (cell == null || !cell.getSymbol().equals(symbol)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean isColWin(Symbol symbol) {
        for (int col = 0; col < gameBoard.getCol(); col++) {
            boolean win = true;
            for (int row = 0; row < gameBoard.getRow(); row++) {
                Cell cell = gameBoard.getCell(row, col);
                if (cell == null || !cell.getSymbol().equals(symbol)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean isDiagonalWin(Symbol symbol) {
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;
        for (int i = 0; i < gameBoard.getRow(); i++) {
            Cell leftCell = gameBoard.getCell(i, i);
            if (leftCell == null || !leftCell.getSymbol().equals(symbol)) {
                leftDiagonal = false;
            }
            Cell rightCell = gameBoard.getCell(i, gameBoard.getCol() - i - 1);
            if (rightCell == null || !rightCell.getSymbol().equals(symbol)) {
                rightDiagonal = false;
            }
        }
        return leftDiagonal || rightDiagonal;
    }
}
