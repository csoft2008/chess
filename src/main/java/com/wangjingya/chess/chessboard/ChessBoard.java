package com.wangjingya.chess.chessboard;

import com.wangjingya.chess.chess.ChessElement;
import com.wangjingya.chess.chess.impl.Grid;

/**
 * 棋盘类
 * 同时实现判胜，落子是否合规等
 */
public class ChessBoard {
    private int rows;  //棋盘的行数，默认为10行*10列
    private Grid grid = new Grid(); //棋盘上的格子
    private int lastRow;  //最后下的一步棋的行和列，方便机器人程序或亮显等
    private int lastCol;
    private boolean isChess = false; //是否已获胜
    private boolean canPlay = true;  //是否还可以继续下棋
    private ChessElement chesses[][] ;  //用于保存下的棋子放的位置

    public ChessBoard(int rows) {
        this.rows = rows;
        chesses = new ChessElement[rows][rows];
    }

    public int getRows() {
        return rows;
    }

    public int getLastRow() {
        return lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }

    public int putChessElement(int row,int col,ChessElement chessElement){
        if(row>rows || col>rows) //输入的位置超过棋盘大小
            return -2;
        if(chesses[row-1][col-1] instanceof Grid) {   //如果当前位置没有落子，可以落子
            chesses[row - 1][col - 1] = chessElement;
            lastCol = col;  //保存最后下的棋子位置
            lastRow = row;
            return 1;  //如果放子成功，返回1，如果该位置不能放，返回为-1
        }else{
            return -1;
        }
    }
    public ChessElement[][] getChesses() {  //获取当前棋子分布
        return chesses;
    }

    public void clearBoard(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                chesses[i][j] = grid;
            }
        }
    }

    public int removeChess(int row,int col){
        return putChessElement(row,col,grid);
    }

    public void draw(){  //把棋盘当前状态画出来
        System.out.println();
        drawLine();
        for(int row=0;row<chesses.length;row++){
            System.out.print((char)(9312 + row%10));
            for(int col=0;col<chesses[row].length;col++){
                chesses[row][col].draw();
            }
            System.out.println((char)(9312 + row%10));
        }
        drawLine();
        System.out.println();
    }
    public void drawLine(){
        System.out.print("☆");
        for(int row=0;row<chesses.length;row++) {
            System.out.print((char)(9312 + row%10));
        }
        System.out.println("☆");
    }
    public void reView(){
        System.out.println();
        drawLine();
        for(int row=0;row<chesses.length;row++){
            System.out.print((char)(9312 + row%10));
            for(int col=0;col<chesses[row].length;col++){
                chesses[row][col].drawNum();
            }
            System.out.println((char)(9312 + row%10));
        }
        drawLine();
        System.out.println();
    }
    public boolean checkWinner() {
        for (int i = 0; i < chesses.length; i++) {
            for (int j = 0; j < chesses[i].length - 4; j++) {
                if (chesses[i][j] != grid && chesses[i][j + 1] != grid && chesses[i][j + 2] != grid && chesses[i][j + 3] != grid
                        && chesses[i][j + 4] != grid) {
                    if (chesses[i][j].getElementType()==(chesses[i][j + 1].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i][j + 2].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i][j + 3].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i][j + 4].getElementType())) {
                        isChess = true;
                        canPlay = false;
                    }
                }
            }
        }
        for (int i = 0; i < chesses.length - 4; i++) {
            for (int j = 0; j < chesses[i].length; j++) {
                if (chesses[i][j] != grid && chesses[i + 1][j] != grid && chesses[i + 2][j] != grid && chesses[i + 3][j] != grid
                        && chesses[i + 4][j] != grid) {
                    if (chesses[i][j].getElementType()==(chesses[i + 1][j].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 2][j].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 3][j].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 4][j].getElementType())) {
                        isChess = true;
                        canPlay = false;
                    }
                }
            }
        }
        for (int i = 0; i < chesses.length - 4; i++) {
            for (int j = 0; j < chesses[i].length - 4; j++) {
                if (chesses[i][j] != grid && chesses[i + 1][j + 1] != grid && chesses[i + 2][j + 2] != grid && chesses[i + 3][j + 3] != grid
                        && chesses[i + 4][j + 4] != grid) {
                    if (chesses[i][j].getElementType()==(chesses[i + 1][j + 1].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 2][j + 2].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 3][j + 3].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 4][j + 4].getElementType())) {
                        isChess = true;
                        canPlay = false;
                    }
                }
            }
        }
        for (int i = 4; i < chesses.length - 4; i++) {
            for (int j = 4; j < chesses[i].length; j++) {
                if (chesses[i][j] != grid &&
                        chesses[i + 1][j - 1] != grid &&
                        chesses[i + 2][j - 2] != grid &&
                        chesses[i + 3][j - 3] != grid
                        && chesses[i + 4][j - 4] != grid) {
                    if (chesses[i][j].getElementType()==(chesses[i + 1][j - 1].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 2][j - 2].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 3][j - 3].getElementType())
                            && chesses[i][j].getElementType()==(chesses[i + 4][j - 4].getElementType())) {
                        isChess = true;
                        canPlay = false;
                    }
                }
            }
        }
        return isChess;
    }
    public boolean canPlay(){
        return canPlay;
    }
}
