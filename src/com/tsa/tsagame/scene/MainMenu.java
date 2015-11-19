package com.tsa.tsagame.scene;

import com.tsa.tsagame.object.MainMenu.Title;
import com.tsa.tsagame.scene.sceneTools.SceneType;
import org.lwjgl.opengl.GL11;

public class MainMenu extends SceneBase {
    public MainMenu(){
        this.usesObjForm = true;
        this.sceneType = SceneType.TYPE_2D;
    }
    @Override
    public void init(){
        Title mainTitle = new Title();
        mainTitle.xpos = 100;
        mainTitle.xpos = 100;
        try {
            this.objectBases.add(mainTitle);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
