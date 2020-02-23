package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 10;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void openTile(int x, int y) {
        if (!gameField[y][x].isFlag && !gameField[y][x].isOpen && !isGameStopped) {
            if (gameField[y][x].isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
            else if (gameField[y][x].countMineNeighbors == 0) {
                setCellValue(x, y, "");
            }
            else setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            gameField[y][x].isOpen = true;
            countClosedTiles--;
            if (!gameField[y][x].isMine) {
                score += 5;
                setScore(score);
            }
            setCellColor(x, y, Color.GREEN);
            List<GameObject> result = null;
            if (gameField[y][x].countMineNeighbors == 0 && !gameField[y][x].isMine) {
                result = getNeighbors(gameField[y][x]);
                for (GameObject gameObject : result) {
                    if (!gameObject.isOpen) {
                        openTile(gameObject.x, gameObject.y);
                    }
                }
            }
            if (countMinesOnField == countClosedTiles && !gameField[y][x].isMine) win();
        }
    }



    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) restart();
        else openTile(x, y);

    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void markTile(int x, int y) {
        if (countFlags == 0 && !gameField[y][x].isFlag) {
        }
        else if (isGameStopped) {
        }
        else  {
            if (!gameField[y][x].isOpen) {
                if (!gameField[y][x].isFlag) {
                    gameField[y][x].isFlag = true;
                    countFlags--;
                    setCellValue(x, y, FLAG);
                    setCellColor(x, y, Color.YELLOW);
                } else {
                    gameField[y][x].isFlag = false;
                    countFlags++;
                    setCellValue(x, y, "");
                    setCellColor(x, y, Color.ORANGE);
                }
            }
        }
    }



    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellValue(x, y, "");
            }
        }
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;

    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Ты проиграл, лошара!", Color.AQUA, 50);
    }
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "Ты выйграл, Лошара!", Color.ORANGE, 50);
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    List<GameObject> neighbors = getNeighbors(gameField[y][x]);
                    for (int i = 0; i < neighbors.size(); i++) {
                        if (neighbors.get(i).isMine) gameField[y][x].countMineNeighbors++;
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
}