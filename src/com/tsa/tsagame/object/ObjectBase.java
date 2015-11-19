package com.tsa.tsagame.object;

public class ObjectBase {
    //Global
    public ObjectType type;
    public int xpos;
    public int ypos;
    public int zpos;
    public int xrot;
    public int yrot;
    public int zrot;
    public int textureLoc;

    //For 2D
    public int[] vertices;
    public int height;
    public int width;

    public ObjectBase(){
        vertices = new int[8];
    }
    public void calculateVertices(){
        vertices[0] = 0;
        vertices[1] = 0;
        vertices[2] = 0;
        vertices[3] = height;
        vertices[4] = width;
        vertices[5] = height;
        vertices[6] = width;
        vertices[7] = 0;
    }

}
