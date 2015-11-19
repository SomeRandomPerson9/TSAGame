package com.tsa.tsagame;

public class TSAGameMain {
    public static Game mainIns;
    public static void main(String[] args){
        mainIns = new Game();
        mainIns.gameLoop();
    }
}
