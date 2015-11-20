package com.tsa.tsagame.object;

import org.newdawn.slick.opengl.Texture;

public class ObjectBase {
    //Global
    public ObjectType type;
    public int xpos;
    public int ypos;
    public int zpos;
    public int xrot;
    public int yrot;
    public int zrot;
    public int[] color = new int[3];

    //For 2D
    public int[] vertices;
    public int height;
    public int width;
    public Texture texture;

    public ObjectBase(){
        vertices = new int[8];
    }
    public int[] calculateVertices(){
        if(vertices == null) {
            vertices[0] = 0;
            vertices[1] = 0;
            vertices[2] = 0;
            vertices[3] = height;
            vertices[4] = width;
            vertices[5] = height;
            vertices[6] = width;
            vertices[7] = 0;
        }
        return vertices;
    }

}
