package com.javarush.games.racer;

public class PlayerCar extends GameObject{

    private static int playerCarHeight = ShapeMatrix.PLAYER.length;
    private Direction direction;
    public int speed = 1;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public PlayerCar() {
        super(RacerGame.WIDTH/2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }

    public void move() {
        if (direction.equals(Direction.LEFT)) {
            x = x - 1;
        }
        else if (direction.equals(Direction.RIGHT)) {
            x = x + 1;
        }
    }
}
