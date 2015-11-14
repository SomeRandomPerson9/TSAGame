package com.tsa.tsagame;

public class MainLoop {
    public final int TARGET_FPS = 60;
    public final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    public float lastFpsTime = OPTIMAL_TIME;
    public float fps = 0;
    public boolean gameRunning = true;
    public void gameLoop()
    {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

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
            doGameUpdates(delta);

            // draw everyting
            render();

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
        //for (int i = 0; i < null.size(); i++)
        {
            //TODO: all time-related values must be multiplied by delta!

        }
    }

    private void render(){

    }
}
