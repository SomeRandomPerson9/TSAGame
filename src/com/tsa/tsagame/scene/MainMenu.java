package com.tsa.tsagame.scene;

import com.tsa.tsagame.Resources;
import com.tsa.tsagame.TSAGameMain;
import com.tsa.tsagame.object.MainMenu.Title;
import com.tsa.tsagame.scene.sceneTools.SceneType;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class MainMenu extends SceneBase {
    public MainMenu(){
        this.usesObjForm = true;
        this.sceneType = SceneType.TYPE_2D;
    }
    @Override
    public void init(){

        //Title
        Texture texture = null;
        try{
            texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(Resources.paths.MainMenu.mainTitle));
        }catch (IOException e){
            e.printStackTrace();
            TSAGameMain.mainIns.close();
        }
        Title mainTitle = new Title(texture);
        mainTitle.xpos = 100;
        mainTitle.xpos = 100;

        try {
            this.objectBases.add(mainTitle);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
