package com.tsa.tsagame.object.MainMenu;

import com.tsa.tsagame.object.ObjectBase;
import com.tsa.tsagame.object.ObjectType;
import org.newdawn.slick.opengl.Texture;

public class Title extends ObjectBase {
    public Title(Texture textureImp){
        this.texture = textureImp;
        this.type = ObjectType.TYPE_2D;
        this.width = textureImp.getImageWidth();
        this.height = textureImp.getTextureHeight();
    }
}
