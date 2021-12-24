package com.wangjingya.chess.chess;

public abstract class ChessElement implements Drawable { //棋盘上的元素的基类，暂时有两个子类Grid和Chess
    private int row;  //在棋盘上的行位置
    private int col;  //在棋盘上的列位置

    private int elementType; //棋盘元素类型 0 Grid,1：BlackChess,2:WhiteChess

    public static final int GRID = 0;
    public static final int BLACKCHESS = 1;
    public static final int WHITECHESS = 2;

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getElementType(){
        return elementType;
    }

    public ChessElement(int elementType) {
        this.elementType = elementType;
    }
}
