package com.upendra.model;

import java.util.Arrays;

public class TicTacToeBoard {
    private final int size;
    private final Piece[][] board;

    public TicTacToeBoard(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public boolean setCellIfEmpty(int row, int col, Piece symbol){
        if(isValidPosition(row, col) && isCellEmpty(row, col)){
            this.board[row][col] = symbol;
            return true;
        }
        return false;
    }

    private boolean isCellEmpty(int row, int col) {
        return this.board[row][col] == null;
    }

    public Piece getCellValue(int row, int col){
        if(!isValidPosition(row, col))
            throw new IndexOutOfBoundsException("Cell is out of bound from board");
        return this.board[row][col];
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size && col >=0 && col < size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            for (int j = 0; j < size; j++) {
                sb.append(isCellEmpty(i,j)?'_':board[i][j]);
            }
            if(i!=size-1)
                sb.append("\n");
        }
        return sb.toString();
    }

    public boolean hasAnyPositionAvailable() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(this.board[i][j]==null)
                    return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }
}
