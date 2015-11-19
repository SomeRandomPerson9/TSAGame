package com.tsa.tsagame.scene;

import com.tsa.tsagame.object.ObjectBase;
import com.tsa.tsagame.scene.sceneTools.SceneType;

import java.util.ArrayList;

public class SceneBase {
    public SceneType sceneType;
    public boolean usesObjForm = true;
    public ArrayList<ObjectBase> objectBases = new ArrayList<ObjectBase>();
    public void init(){

    }
    public void update(double delta){

    }
    public void render(){

    }
}
