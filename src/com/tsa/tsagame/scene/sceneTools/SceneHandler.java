package com.tsa.tsagame.scene.sceneTools;

import com.tsa.tsagame.Resources;
import com.tsa.tsagame.scene.SceneBase;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class SceneHandler {
    private ArrayList<SceneBase> sceneBases = new ArrayList<SceneBase>();
    private SceneBase currentScene;
    public void addScene(SceneBase sceneBase, int index){
        sceneBases.add(index, sceneBase);
    }
    public void changeScene(int index){
        SceneBase lastScene;
        lastScene = currentScene;
        currentScene = sceneBases.get(index);
        if(lastScene != null){
            if(currentScene.sceneType != lastScene.sceneType){
                if(currentScene.sceneType == SceneType.TYPE_2D){
                    GL11.glMatrixMode(GL11.GL_PROJECTION);
                    GL11.glLoadIdentity();
                    GL11.glOrtho(0, Resources.WINDOW_WIDTH, 0, Resources.WINDOW_HEIGHT, 1, -1);
                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
                }
            }
            else{
                return;
            }
        }
        else{
            if(currentScene.sceneType == SceneType.TYPE_2D){
                GL11.glMatrixMode(GL11.GL_PROJECTION);
                GL11.glLoadIdentity();
                GL11.glOrtho(0, Resources.WINDOW_WIDTH, 0, Resources.WINDOW_HEIGHT, 1, -1);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
            }
            else{
                return;
            }
        }
    }
    public void update(double delta){

        currentScene.update(delta);
    }
    public void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        currentScene.render();
    }
    public void init(){
        for(SceneBase sceneBase : sceneBases){
            sceneBase.init();
        }
    }
}
