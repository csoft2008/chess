package com.wangjingya.chess.game;

import com.wangjingya.chess.chess.impl.BlackChess;
import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chessboard.ChessBoard;
import com.wangjingya.chess.chess.impl.WhiteChess;
import com.wangjingya.player.Player;

/**
 * 游戏主要过程类
 * 记录步数
 * 提示玩家落子等
 */
public class Game {
    private ChessBoard chessBoard;
    private Player blackPlayer;  //两个游戏玩家
    private Player whitePlayer;

    public Game(ChessBoard chessBoard, Player blackPlayer, Player whitePlayer) {
        this.chessBoard = chessBoard;
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public void play(){
        chessBoard.clearBoard(); //将棋盘中的子清空
        chessBoard.draw(); //画出空棋盘

        int i = 1; //记步数
        String comment = "";   //提示信息
        String chessType = "";  //提示中，对黑白棋的区分
        int col,row;

        while (true) {  //每一步，一次循环
            //提示落子
            comment = "请落子，请输入想在第几行第几列落子，\n\r比如2 3，表示第2行第3列落子，\n\r输入0 0表示结束游戏";
            if(i%2==0){
                chessType = "白棋";
            }else{
                chessType = "黑棋";
            }
            comment = "第" + i +"步:" + chessType + comment;
            System.out.println(comment);  //给出落子提示

            //Player落子
            Chess chess;
            if(i%2==0){
                chess = whitePlayer.putChess(new WhiteChess());
            }else{
                chess = blackPlayer.putChess(new BlackChess());
            }
            row = chess.getRow();
            col = chess.getCol();
            chess.setNum(i);
            if(row==0) {
                System.out.println("感谢使用，再见！");
                break;
            }

            //落子到棋盘上
            int result;
            result = chessBoard.putChessElement(row, col,chess);

            //判断落子是否合规
            if(result ==-1) {
                System.out.println("该处已有棋子，请重新落子");
                continue;
            }else if(result == -2){
                System.out.println("位置超过棋盘大小，请重新落子");
                continue;
            }

            chessBoard.draw();
            chessBoard.checkWinner();
            if(!chessBoard.canPlay()){
                System.out.println(chessType + "获胜，游戏已结束！");
                break;
            }
            i++;  //进入下一步
        }
        chessBoard.reView();
    }
}
