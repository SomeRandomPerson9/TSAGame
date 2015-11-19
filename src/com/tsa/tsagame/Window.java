package com.tsa.tsagame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
    public void create(int width, int height){
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
        }catch(LWJGLException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void update(){
        Display.update();
    }
    public boolean isCloseRequested(){
        return Display.isCloseRequested();
    }
    public void close(){
        Display.destroy();
    }
}
