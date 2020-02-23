package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EnemyFleet {
    public EnemyFleet() {
        createShips();
    }
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;
    private void createShips() {
        this.ships = new ArrayList<EnemyShip>();
        for (int i = 0; i < ROWS_COUNT ; i++) {
            for (int j = 0; j < COLUMNS_COUNT; j++) {
                ships.add(new EnemyShip(j * STEP, i * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1,5));
    }

    public void draw(Game game) {
        for (EnemyShip ship : ships) {
            ship.draw(game);
        }
    }

    public void move() {
        if (ships.size() != 0) {
            double speed = getSpeed();
            if (direction.equals(Direction.LEFT) && getLeftBorder() < 0) {
                direction = (Direction.RIGHT);
                for (EnemyShip ship : ships) ship.move(Direction.DOWN, speed);
            }
            else if (direction.equals(Direction.RIGHT) && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = (Direction.LEFT);
                for (EnemyShip ship : ships) ship.move(Direction.DOWN, speed);
            }
            else { for (EnemyShip ship : ships) ship.move(direction, speed);
            }
        }
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) return null;
        else {
            if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) return null;
            else {
                return ships.get(game.getRandomNumber(ships.size())).fire();
            }
        }
    }


    public void deleteHiddenShips() {
        ships.removeIf(ship -> !ship.isVisible());
    }

    public int getShipsCount() {
        int count = 0;
        for(EnemyShip ship : ships) {
            count++;
        }
        return count;
    }

    private double getLeftBorder() {
        ArrayList<Double> list= new ArrayList<>();
        for(EnemyShip ship : ships) {
            list.add(ship.x);
        }
        return Collections.min(list);
    }

    private double getRightBorder() {
        ArrayList<Double> list= new ArrayList<>();
        for(EnemyShip ship : ships) {
            list.add(ship.x + ship.width);
        }
        return Collections.max(list);
    }

    public double getBottomBorder() {
        if (ships.size() > 0) {
            ArrayList<Double> y = new ArrayList<>();
            for (EnemyShip ship : ships) {
                y.add(ship.y + ship.height);
            }
            return Collections.max(y);
        }
        else return 0;
    }

    public int verifyHit(List<Bullet> bullets) {
        if (bullets.size() == 0) return  0;
            int score = 0;
            for (int i = 0; i < ships.size(); i++) {
                for (int j = 0; j < bullets.size(); j++) {
                    if (ships.get(i).isCollision(bullets.get(j)) && ships.get(i).isAlive && bullets.get(j).isAlive) {
                        ships.get(i).kill();
                        score += ships.get(i).score;
                        bullets.get(j).kill();
                    }
                }
            }
            return score;
        }


    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }
}