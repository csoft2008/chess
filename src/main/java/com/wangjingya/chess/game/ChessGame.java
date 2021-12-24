package com.wangjingya.chess.game;

import com.wangjingya.chess.chessboard.ChessBoard;
import com.wangjingya.player.PlayerFactory;
import com.wangjingya.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整个游戏类
 * 主要实现游戏正式开始前准备工作，游戏主过程，比如落子等由Game类实现
 */
public class ChessGame {
    private int rows;
    private Scanner scanner = new Scanner(System.in);
    public void setRows(){

        while (rows<5){
            System.out.println("请输入棋盘的行数(不小于5)：");
            try {
                rows = scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("请输入不小于5的数字");
            }
        }
    }

    public Player selectPlayer(){
        String strPlayer = null;
        System.out.println("请输入数字选择棋手：");
        System.out.println("1.键盘选手");
        System.out.println("2.随机机器人选手");
        System.out.println("3.简单机器人选手");
        System.out.println("4.AI机器人选手");
        int option = 0;
        try{
            option = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("输入数字不在范围内，自动为您选择1");
        }

        switch (option){
            case 1:
                strPlayer="CONSOLERPLAYER";
                break;
            case 2:
                strPlayer="RANDOMROBOTPLAYER";
                break;
            case 3:
                strPlayer="SIMPLEROBOTPLAYER";
                break;
            case 4:
                strPlayer="AIROBOTPLAYER";
                break;
            default:
                strPlayer="CONSOLERPLAYER";
        }

        PlayerFactory playerFactory = new PlayerFactory();  //通过工厂方法模式来选择不同的实现类
        Player player = playerFactory.getPlayer(strPlayer); //使用AI机器人实现
        return player;
    }
    public void start(){
        setRows();  //获得棋盘行数
        ChessBoard chessBoard = new ChessBoard(rows);  //配置棋盘

        System.out.println("请为黑方选择棋手");
        Player blackPlayer = selectPlayer();   //设置黑方棋手
        System.out.println("请为白方选择棋手");
        Player whitePlayer = selectPlayer();   //设置白方棋手

        Game game = new Game(chessBoard,blackPlayer,whitePlayer);    //创建游戏
        blackPlayer.seeChessBoard(chessBoard);                       //如果是机器人，把棋盘给机器人
        whitePlayer.seeChessBoard(chessBoard);

        game.play();                                                 //开始游戏

        blackPlayer.overGame();                                      //主要是用于一些释放资源的操作
        whitePlayer.overGame();

        scanner.close();
    }
}
