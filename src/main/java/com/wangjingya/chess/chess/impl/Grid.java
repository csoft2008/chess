package com.wangjingya.chess.chess.impl;

import com.wangjingya.chess.chess.ChessElement;

public class Grid extends ChessElement {
    public Grid() {
        super(ChessElement.GRID);
    }

    private final static char GRID_CHAR = '┼';
    @Override
    public void draw() {
        System.out.printf(String.valueOf(GRID_CHAR));
    }

    @Override
    public void drawNum() {
        draw();
    }
}
