package com.tsa.tsagame.scene.sceneTools;

import com.tsa.tsagame.Resources;
import com.tsa.tsagame.TSAGameMain;
import com.tsa.tsagame.exception.ObjectAtribException;
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
                    GL11.glEnable(GL11.GL_TEXTURE_2D);

                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

                    GL11.glMatrixMode(GL11.GL_PROJECTION);
                    GL11.glLoadIdentity();
                    GL11.glOrtho(0, Resources.global.WINDOW_WIDTH, 0, Resources.global.WINDOW_HEIGHT, 1, -1);
                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
                }
            }
            else{
                return;
            }
        }
        else{
            if(currentScene.sceneType == SceneType.TYPE_2D){
                GL11.glEnable(GL11.GL_TEXTURE_2D);

                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

                GL11.glMatrixMode(GL11.GL_PROJECTION);
                GL11.glLoadIdentity();
                GL11.glOrtho(0, Resources.global.WINDOW_WIDTH, 0, Resources.global.WINDOW_HEIGHT, 1, -1);
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

                    if(objectBase.texture != null) {
                        objectBase.texture.bind();
                        GL11.glColor3f(1, 1, 1);

                        GL11.glTranslatef(objectBase.xpos, objectBase.ypos, objectBase.zpos);

                        GL11.glBegin(GL11.GL_QUADS);

                        GL11.glTexCoord2f(0, 0);
                        GL11.glVertex2f(0, 0);
                        GL11.glTexCoord2f(0, objectBase.texture.getHeight());
                        GL11.glVertex2f(0, objectBase.height);
                        GL11.glTexCoord2f(objectBase.texture.getImageWidth(), objectBase.texture.getImageHeight());
                        GL11.glVertex2f(objectBase.width, objectBase.height);
                        GL11.glTexCoord2f(objectBase.texture.getImageWidth(), 0);
                        GL11.glVertex2f(objectBase.width, 0);

                        GL11.glEnd();
                    }
                    else{
                        GL11.glColor3f(objectBase.color[0], objectBase.color[1], objectBase.color[2]);

                        GL11.glTranslatef(objectBase.xpos, objectBase.ypos, objectBase.zpos);

                        GL11.glBegin(GL11.GL_QUADS);

                        GL11.glVertex2f(0, 0);
                        GL11.glVertex2f(0, objectBase.height);
                        GL11.glVertex2f(objectBase.width, objectBase.height);
                        GL11.glVertex2f(objectBase.width, 0);

                        GL11.glEnd();
                    }
                    GL11.glPopMatrix();

                }
            }
            else if(currentScene.sceneType == SceneType.TYPE_3D){
                //TODO: 3D Rendering
            }
            else{
                new ObjectAtribException("Scene Type not Specified").printStackTrace();
                TSAGameMain.mainIns.close();
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
