package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - RacerGame.ROADSIDE_WIDTH;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        } else {
            return new Car(RoadObjectType.CAR, x, y);
        }
    }
    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject newObject = createRoadObject(type, x, y);
        if (newObject != null) {
            items.add(newObject);
        }
    }

    private boolean isThornExists() {
        for (RoadObject item : items) {
            if (item instanceof Thorn) {
                return true;
            }
        }
        return false;
    }

    private void generateThorn(Game game) {
        int number = game.getRandomNumber(100);
        if (number < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
    }

    private void generateRegularCar(Game game) {
        int num = game.getRandomNumber(100);
        int carTypeNumber = game.getRandomNumber(4);
        if (num < 30) {
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
        }
    }

    public void draw(Game game) {
        for(RoadObject item : items) {
            item.draw(game);
        }
    }
    public void move(int boost) {
        for(RoadObject item : items) {
            item.move(boost + item.speed);
        }
        deletePassedItems();
    }

    private void deletePassedItems() {
        items.removeIf(item -> item.y >= RacerGame.HEIGHT);
    }

    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject item : items) {
            if(item.isCollision(playerCar)) {
                return true;
            }
        }
        return false;
    }
}
