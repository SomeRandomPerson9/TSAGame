package com.tsa.tsagame.scene.sceneTools;

import com.tsa.tsagame.Resources;
import com.tsa.tsagame.object.ObjectBase;
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
        if(currentScene.usesObjForm){
            if(currentScene.sceneType == SceneType.TYPE_2D){
                for(ObjectBase objectBase :currentScene.objectBases){
                    int[] vertices = objectBase.calculateVertices();
                    GL11.glPushMatrix();
                    //texture.bind();
                    GL11.glTranslatef(objectBase.xpos, objectBase.ypos, objectBase.zpos);
                    GL11.glColor3f(1,1,1);

                    GL11.glBegin(GL11.GL_QUADS);

                    //GL11.glTexCoord2f(0, 0);
                    GL11.glVertex2f(0, 0);
                    //GL11.glTexCoord2f(0, 0);
                    GL11.glVertex2f(0, objectBase.height);
                    //GL11.glTexCoord2f(0, 0);
                    GL11.glVertex2f(objectBase.width, objectBase.height);
                    //GL11.glTexCoord2f(0, 0);
                    GL11.glVertex2f(objectBase.width, 0);

                    GL11.glEnd();

                    GL11.glPopMatrix();

                }
            }
        }
        else {
            currentScene.render();
        }
    }
    public void init(){
        for(SceneBase sceneBase : sceneBases){
            sceneBase.init();
        }
    }
}
