package com.example.android_with_jbehave;


public class Game {
    boolean[][] map = null;

    public Game(int w, int h) {
        map = new boolean[h][w];
    }

    public void setObserver(StringRenderer renderer) {
        renderer.game = this;
    }

    public void toggleCellAt(int w, int h) {
        map[h][w] = !map[h][w];
    }
}
