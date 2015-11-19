package com.tsa.tsagame;

import com.tsa.tsagame.scene.sceneTools.SceneHandler;
import com.tsa.tsagame.scene.sceneTools.ScenesList;

public class Game {
    //Parts of Game
    public Window window;
    public SceneHandler sceneHandler;

    //Variables for Loop
    public final int TARGET_FPS = 60;
    public final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;;
    public float lastFpsTime = OPTIMAL_TIME;
    public float fps = 0;
    public boolean gameRunning = true;

    Game(){
        window = new Window();
        sceneHandler = new SceneHandler();
    }

    public void gameLoop()
    {
        long lastLoopTime = System.nanoTime();

        init();

        // keep looping round til the game ends
        while (gameRunning)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: "+fps+")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            this.doGameUpdates(delta);

            // draw everyting
            this.render();

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try{
                Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }catch (Exception e){};
        }
    }

    private void doGameUpdates(double delta)
    {
        //Close Program
        if(window.isCloseRequested()){
            close();
            return;
        }

        window.update();
        sceneHandler.update(delta);
    }

    private void render(){
        sceneHandler.render();
    }

    private void init(){
        window.create(Resources.WINDOW_WIDTH, Resources.WINDOW_HEIGHT);
        sceneHandler.addScene(ScenesList.mainMenu, 0);
        sceneHandler.init();
        sceneHandler.changeScene(0);
    }
    private void close(){
        window.close();
        gameRunning = false;
    }
}
