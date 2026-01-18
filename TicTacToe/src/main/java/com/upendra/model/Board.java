package com.upendra.model;

public abstract class Board {
    private final int row;
    private final int col;
    private final Cell[][] board;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new Cell[row][col];
    }

    public void setCell(int row, int col, Cell cell) {
        if (!isValidPosition(row, col)) {
            throw new IndexOutOfBoundsException("Cell is out of bound from board");
        }
        this.board[row][col] = cell;
    }

    public Cell getCell(int row, int col) {
        if (!isValidPosition(row, col))
            throw new IndexOutOfBoundsException("Cell is out of bound from board");
        return this.board[row][col];
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < this.row && col >= 0 && col < this.col;
    }

    public boolean isCellEmpty(int i, int j) {
        return this.board[i][j]==null;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<row;i++){
            for (int j = 0; j < col; j++) {
                sb.append(isCellEmpty(i,j)?'_':board[i][j]);
            }
            if(i!=row-1)
                sb.append("\n");
        }
        return sb.toString();
    }
}
