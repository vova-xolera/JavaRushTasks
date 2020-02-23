package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private boolean isGameStopped;
    private int animationsCount;
    private int score;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private List<Bullet> playerBullets;

    private void createGame() {
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        createStars();
        this.setTurnTimer(40);
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        drawScene();
    }

    private void drawScene() {
        drawField();
        playerShip.draw(this);
        for(Bullet bullet : enemyBullets) bullet.draw(this);
        for(Bullet bullet : playerBullets) bullet.draw(this);
        enemyFleet.draw(this);
    }

    private void drawField() {
        for(int y = 0; y < HEIGHT; y++) {
            for(int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for  (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(getRandomNumber(64), getRandomNumber(64)));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        drawField();
        playerShip.move();
        for(Bullet bullet : enemyBullets) bullet.move();
        for(Bullet bullet : playerBullets) bullet.move();
    }

    private void removeDeadBullets() {
        for(int i = 0; i < enemyBullets.size(); i ++) {
            if (enemyBullets.get(i).y >= HEIGHT - 1 || !enemyBullets.get(i).isAlive) enemyBullets.remove(i);
        }
        playerBullets.removeIf(bullet -> bullet.y + bullet.height < 0 || !bullet.isAlive);
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        enemyFleet.deleteHiddenShips();
        score += enemyFleet.verifyHit(playerBullets);
        double border = enemyFleet.getBottomBorder();
        if (border >= playerShip.y) playerShip.kill();
        int enemyCount = enemyFleet.getShipsCount();
        if (enemyCount == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
        removeDeadBullets();
        if (!playerShip.isAlive) stopGameWithDelay();
    }

    @Override
    public void setCellValueEx(int x, int y, Color color, String string) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) super.setCellValueEx(x,y,color,string);
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key.toString().equals("LEFT") && playerShip.getDirection() == Direction.LEFT) playerShip.setDirection(Direction.UP);
        if (key.toString().equals("RIGHT") && playerShip.getDirection() == Direction.RIGHT) playerShip.setDirection(Direction.UP);
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) showMessageDialog(Color.WHITE,"You are win!", Color.GREEN, 50);
        else showMessageDialog(Color.WHITE,"Sorry, you are lose!", Color.RED, 50);
    }
    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) stopGame(playerShip.isAlive);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key.toString().equals("SPACE") && isGameStopped) createGame();
        if (key.toString().equals("LEFT")) playerShip.setDirection(Direction.LEFT);
        if (key.toString().equals("RIGHT")) playerShip.setDirection(Direction.RIGHT);
        if (key.toString().equals("SPACE")) {
            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) playerBullets.add(bullet);
        }

    }

    @Override
    public void onTurn(int a) {
        setScore(score);
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) enemyBullets.add(bullet);
        drawScene();
    }
}