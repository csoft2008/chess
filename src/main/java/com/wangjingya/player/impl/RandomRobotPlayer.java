package com.wangjingya.player.impl;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chessboard.ChessBoard;
import com.wangjingya.player.Player;

import java.util.Random;

public class RandomRobotPlayer implements Player {
    private ChessBoard chessBoard;

    Random rand =new Random();

    @Override
    public void overGame() {

    }

    @Override
    public void seeChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    @Override
    public Chess putChess(Chess chess) {
        int rows = chessBoard.getRows();
        int row = rand.nextInt(rows) + 1;
        int col = rand.nextInt(rows) + 1;
        if(row<1||col<1||row>rows||col>rows){
            row = rows/2;
            col = rows/2;
        }
        chess.setRow(row);
        chess.setCol(col);
        System.out.println("我是随机机器人，我想落在第" + row +"行，第"+ col+"行上。");
        return chess;
    }
}
