package com.wangjingya.player.impl;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chessboard.ChessBoard;
import com.wangjingya.player.Player;

import java.util.Random;

public class SimpleRobotPlayer implements Player {
        private static final int LEFT = 0;
        private static final int RIGHT = 1;
        private static final int UP = 2;
        private static final int DOWN = 3;
        private static final int LEFTUP = 4;
        private static final int RIGHTUP = 5;
        private static final int LEFTDOWN = 6;
        private static final int RIGHTDOWN = 7;
        private ChessBoard chessBoard;
        private Random rand =new Random();

        @Override
        public void seeChessBoard(ChessBoard chessBoard) {
            this.chessBoard = chessBoard;
        }
        @Override
        public void overGame() {

        }

        @Override
        public Chess putChess(Chess chess) {
            int rows = chessBoard.getRows();
            int lastRow = chessBoard.getLastRow();
            int lastCol = chessBoard.getLastCol();
            int direction = rand.nextInt(8);
            int row,col;
            switch (direction){
                case LEFT:
                    row = lastRow;
                    col = lastCol - 1;
                    break;
                case RIGHT:
                    row = lastRow;
                    col = lastCol + 1;
                    break;
                case UP:
                    row = lastRow -1;
                    col = lastCol;
                    break;
                case DOWN:
                    row = lastRow +1;
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
            if(row<1||col<1||row>rows||col>rows){
                row = rows/2;
                col = rows/2;
            }
            chess.setRow(row);
            chess.setCol(col);
            System.out.println("我是简单机器人，我想落在第" + row +"行，第"+ col+"行上。");
            return chess;
        }
}


