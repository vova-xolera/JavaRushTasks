package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
        public static final int WIDTH = 64;
        public static final int HEIGHT = 64;
        public static final int CENTER_X = WIDTH/2;
        public static final int ROADSIDE_WIDTH = 14;
        private static final int RACE_GOAL_CARS_COUNT = 40;
        private RoadMarking roadMarking;
        private PlayerCar player;
        private RoadManager roadManager;
        private FinishLine finishLine;
        private ProgressBar progressBar;
        private boolean isGameStopped;
        private int score;
        

        @Override
        public void initialize() {
                setScreenSize(WIDTH, HEIGHT);
                showGrid(false);
                createGame();
        }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player)) {
            gameOver();
            drawScene();
            return;
        }
        roadManager.generateNewRoadObjects(this);
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
            finishLine.show();
        }
        if (finishLine.isCrossed(player)) {
            win();
            drawScene();
            return;
        }
        moveAll();
        score -= 5;
        setScore(score);
        drawScene();
    }

    private void createGame() {
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();
        setTurnTimer(40);
        isGameStopped = false;
        score = 3500;
    }

        private void drawScene() {
                drawField();
                roadMarking.draw(this);
                player.draw(this);
                roadManager.draw(this);
                finishLine.draw(this);
                progressBar.draw(this);
        }
        
        private void drawField() {
                for (int x = 0; x < WIDTH; x++) {
                        for (int y = 0; y < HEIGHT; y++) {
                                if (x == CENTER_X) {
                                        setCellColor(x, y, Color.WHITE);
                                } else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) {
                                        setCellColor(x, y, Color.DIMGRAY);
                                } else {
                                        setCellColor(x, y, Color.GREEN);
                                }
                        }
                }
        }

        @Override
        public void setCellColor(int x, int y, Color color) {
                if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
                        super.setCellColor(x,y,color);
                }
        }

        private void moveAll() {
                roadMarking.move(player.speed);
                player.move();
                roadManager.move(player.speed);
                finishLine.move(player.speed);
                progressBar.move(roadManager.getPassedCarsCount());
        }
        

        @Override
        public void onKeyPress(Key key) {
                if (key.equals(Key.RIGHT)) {
                        player.setDirection(Direction.RIGHT);
                }
                else if (key.equals(Key.LEFT)) {
                        player.setDirection(Direction.LEFT);
                }
                else if (isGameStopped && key.equals(Key.SPACE)) {
                        createGame();
                }
                else if (key.equals(Key.UP)) {
                        player.speed = 2;
                }
        }

        @Override
        public void onKeyReleased(Key key) {
                if ((key.equals(Key.RIGHT) && player.getDirection().equals(Direction.RIGHT)) || (key.equals(Key.LEFT) && player.getDirection().equals(Direction.LEFT))) {
                        player.setDirection(Direction.NONE);
                }
                else if (key.equals(Key.UP)) {
                        player.speed = 1;
                }

        }

        private void win() {
                isGameStopped = true;
                showMessageDialog(Color.WHITE,"CONGRADS!!", Color.GREEN,40);
                stopTurnTimer();
        }

        private void gameOver() {
                isGameStopped = true;
                showMessageDialog(Color.WHITE,"GAME OVER", Color.RED,40);
                stopTurnTimer();
                player.stop();
        }
}