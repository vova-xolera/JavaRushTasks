package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {
    public boolean isAlive = true;
    private List<int[][]> frames;
    private int frameIndex;
    private boolean loopAnimation = false;



    public Ship(double x, double y) {
        super(x, y);
        new GameObject(x,y);
    }

    public boolean isVisible() {
        return isAlive || frameIndex < frames.size();
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public void nextFrame() {
        frameIndex++;
        if ((frameIndex >= frames.size() && !loopAnimation)) {
        }
        else {
            if (frameIndex >= frames.size() && loopAnimation) {
                frameIndex = 0;
            } else {
                matrix = frames.get(frameIndex);
            }
        }
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    public Bullet fire() {
        return null;
    }
    public void kill() {
        isAlive = false;
    }
}
