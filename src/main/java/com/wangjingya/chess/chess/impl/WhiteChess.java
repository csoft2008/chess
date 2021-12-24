package com.wangjingya.chess.chess.impl;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chess.ChessElement;

public class WhiteChess extends Chess {

    public WhiteChess() {
        super(ChessElement.WHITECHESS);
    }

    @Override
    public void draw() {
        System.out.print(Chess.WHITE_CHESS_CHAR);
    }
}
