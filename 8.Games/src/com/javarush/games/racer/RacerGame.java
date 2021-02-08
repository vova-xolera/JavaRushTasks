package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class RacerGame extends Game {
        public static final int WIDTH = 64;
        public static final int HEIGHT = 64;
        public static final int CENTER_X = WIDTH/2;
        public static final int ROADSIDE_WIDTH = 14;


        @Override
        public void initialize() {
                setScreenSize(WIDTH, HEIGHT);
                showGrid(false);
                createGame();
        }

        private void createGame() {
               drawScene();
        }

        private void drawScene() {
                drawField();
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

}