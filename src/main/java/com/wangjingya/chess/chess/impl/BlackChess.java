package com.wangjingya.chess.chess.impl;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chess.ChessElement;

public class BlackChess extends Chess {
    public BlackChess() {
        super(ChessElement.BLACKCHESS);
    }

    @Override
    public void draw() {
        System.out.print(Chess.BLACK_CHESS_CHAR);
    }


}
