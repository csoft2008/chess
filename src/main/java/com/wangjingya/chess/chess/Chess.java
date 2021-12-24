package com.wangjingya.chess.chess;

public abstract class Chess extends ChessElement {
    private int num;  //第几步下的棋

    public void setNum(int num) {
        this.num = num;
    }

    public final static char BLACK_CHESS_CHAR = '○';
    public final static char WHITE_CHESS_CHAR = '●';

    public Chess(int elementType) {
        super(elementType);
    }

    @Override
    public void drawNum() {
        System.out.printf("%02d",num);
    } //复盘时，输出该棋子落子的次序，保留两位，不足补0
}
