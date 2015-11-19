package com.tsa.tsagame.scene;

import com.tsa.tsagame.scene.sceneTools.SceneType;
import org.lwjgl.opengl.GL11;

public class MainMenu extends SceneBase {
    public MainMenu(){
        this.sceneType = SceneType.TYPE_2D;
    }
    @Override
    public void render(){
        GL11.glColor3f(0.5f,0.5f,1.0f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(100,100);
        GL11.glVertex2f(100+200,100);
        GL11.glVertex2f(100+200,100+200);
        GL11.glVertex2f(100,100+200);
        GL11.glEnd();
    }
}
