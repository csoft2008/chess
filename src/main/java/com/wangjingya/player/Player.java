package com.wangjingya.player;

import com.wangjingya.chess.chess.Chess;
import com.wangjingya.chess.chessboard.ChessBoard;

public interface Player {
    void overGame();
    Chess putChess(Chess chess);
    void seeChessBoard(ChessBoard chessBoard);
}
