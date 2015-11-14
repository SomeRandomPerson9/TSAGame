package com.tsa.tsagame;

public class Game {
    public void start(){
        Game game = new Game();
        game.startForRealzies();
    }

    private void startForRealzies() {
        MainLoop.gameLoop();
    }
}
