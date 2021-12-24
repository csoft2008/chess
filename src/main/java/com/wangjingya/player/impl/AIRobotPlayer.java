package com.wangjingya.player.impl;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chessboard.ChessBoard;
import com.wangjingya.chess.chess.ChessElement;
import com.wangjingya.player.Player;

import java.util.HashMap;
import java.util.Random;

public class AIRobotPlayer implements Player {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private static final int LEFTUP = 4;
    private static final int RIGHTUP = 5;
    private static final int LEFTDOWN = 6;
    private static final int RIGHTDOWN = 7;

    private ChessBoard chessBoard;
    private int rows;
    private ChessElement[][] chesses;

    @Override
    public void seeChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.rows = chessBoard.getRows();
        this.chesses = chessBoard.getChesses();
        this.chess = new int[rows][rows];
        this.chessValue = new int[rows][rows];
    }
    private int[][] chess;
    private int[][] chessValue;
    private int x =0,y = 0,max = 0;
    private Random rand =new Random();
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    private HashMap<String, Integer> hm = new HashMap<String, Integer>();

    public void setValue() {
        hm.put("1", 20);
        hm.put("11", 200);
        hm.put("111", 2000);
        hm.put("1111", 3000);
        hm.put("12", 10);
        hm.put("112", 100);
        hm.put("1112", 1000);
        hm.put("11112", 2000);
    }

    public int[] firstPlay(){
        int[] point = new int[2];
        Random rand = new Random();
        int x = 405+rand.nextInt(100);
        int y = 405+rand.nextInt(100);
        point[0]=x;
        point[1]=y;
        return point;
    }

    public void clearValue(){
        for(int i=0;i<chessValue.length;i++){
            for(int j=0;j<chessValue[i].length;j++){
                chessValue[i][j]=0;
            }
        }
    }

    public void doAI(int plaColor) {
        setValue();
        //clearValue();
        for (int i = 0; i < chesses.length; i++) {
            for (int j = 0; j < chesses[i].length; j++) {
                if (chesses[i][j].getElementType() == 0) {
                    String code = "";
                    int color = 1;
                    // 向右
                    for (int k = i + 1; k < chesses.length; k++) {
                        if (chesses[k][j].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) { // 右边第一颗棋子
                                color = chesses[k][j].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[k][j].getElementType() == plaColor) { // 右边第二，三..同颜色棋子
                                code += 1; // 保存棋局
                            } else { // 右边不同颜色
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    Integer value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value;// 权值累加
                    }

                    // 向左
                    for (int k = i - 1; k >= 0; k--) {
                        if (chesses[k][j].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[k][j].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[k][j].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }

                    // 向上
                    for (int k = j + 1; k < chesses[i].length; k++) {
                        if (chesses[i][k].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[i][k].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[i][k].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }

                    // 向下
                    for (int k = j - 1; k > 0; k--) {
                        if (chesses[i][k].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[i][k].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[i][k].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }
                    // 左斜向上
                    for (int k = 1; i-k >0&&j-k>0 ; k++) {
                        if (chesses[i-k][j-k].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[i-k][j-k].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[i-k][j-k].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }
                    // 右斜向下
                    for (int k = 1; i+k<chesses.length&&j+k<chesses[i].length ; k++) {
                        if (chesses[i+k][j+k].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[i+k][j+k].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[i+k][j+k].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }
                    // 右斜向上
                    for (int k = 1; j-k>0&&i+k<chesses[i].length ; k++) {
                        if (chesses[i+k][j-k].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[i+k][j-k].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[i+k][j-k].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }
                    // 左斜向下
                    for (int k = 1; j+k<chesses.length&&i-k>0; k++) {
                        if (chesses[i-k][j+k].getElementType() == 0) {
                            break;
                        } else {
                            if (color == plaColor) {
                                color = chesses[i-k][j+k].getElementType(); // 保存颜色
                                code += 1; // 保存棋局
                            } else if (chesses[i-k][j+k].getElementType() == plaColor) {
                                code += 1; // 保存棋局
                            } else {
                                code += 2; // 保存棋局
                                break;
                            }
                        }
                    }
                    // 根据code取出hm对应的权值
                    value = hm.get(code);
                    if (value != null) {
                        chessValue[i][j] += value; // 权值累加
                    }
                }
                else{
                    chessValue[i][j] = 0;
                }
            }

        }
        max=0;
        for(int i = 0; i<chessValue.length;i++){
            for(int j=0; j<chessValue[i].length; j++){
                if(max<chessValue[i][j]){
                    max = chessValue[i][j];
                    x=i;
                    y=j;
                }
            }
        }
    }

    @Override
    public void overGame() {

    }

    @Override
    public Chess putChess(Chess chess) {
        doAI(chess.getElementType());
        int row, col;

        if(max==0) {
            int rows = chessBoard.getRows();
            int lastRow = chessBoard.getLastRow();
            int lastCol = chessBoard.getLastCol();
            int direction = rand.nextInt(8);

            switch (direction) {
                case LEFT:
                    row = lastRow;
                    col = lastCol - 1;
                    break;
                case RIGHT:
                    row = lastRow;
                    col = lastCol + 1;
                    break;
                case UP:
                    row = lastRow - 1;
                    col = lastCol;
                    break;
                case DOWN:
                    row = lastRow + 1;
                    col = lastCol;
                    break;
                case LEFTUP:
                    row = lastRow - 1;
                    col = lastCol - 1;
                    break;
                case RIGHTUP:
                    row = lastRow - 1;
                    col = lastCol + 1;
                    break;
                case LEFTDOWN:
                    row = lastRow + 1;
                    col = lastCol - 1;
                    break;
                case RIGHTDOWN:
                    row = lastRow + 1;
                    col = lastCol + 1;
                    break;
                default:
                    row = rand.nextInt(rows) + 1;
                    col = rand.nextInt(rows) + 1;
            }
        }else{
            row = x + 1;
            col = y + 1;
        }
        if(row<1||col<1||row>rows||col>rows){
            row = rows/2;
            col = rows/2;
        }
        chess.setRow(row);
        chess.setCol(col);
        System.out.println("我是AI机器人，我想落在第" + row +"行，第"+ col+"行上。");
        return chess;
    }
}
