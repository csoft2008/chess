package com.wangjingya.player.impl;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chessboard.ChessBoard;
import com.wangjingya.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolerPlayer implements Player {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Chess putChess(Chess chess) {
        int row,col;
        try {
            row = scanner.nextInt();
            col = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine(); //吸收不正确的录入
            System.out.println("输入格式不对，请使用空格间隔，例如：2 3，请重新落子");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }
        chess.setRow(row);
        chess.setCol(col);
        return chess;
    }

    @Override
    public void seeChessBoard(ChessBoard chessBoard) {

    }

    @Override
    public void overGame() {
        scanner.close();
    }

}
