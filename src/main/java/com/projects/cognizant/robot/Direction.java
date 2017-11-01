package com.projects.cognizant.robot;


import java.util.HashMap;
import java.util.Map;

public enum Direction {

    SOUTH(0), EAST(1), NORTH(2), WEST(3);
    private static Map<Integer, Direction> map = new HashMap<>();

    static {
        for (Direction directionEnum : Direction.values()) {
            map.put(directionEnum.directionIndex, directionEnum);
        }
    }

    private int directionIndex;


    public Direction turnToLeft() {
        return this.ordinal() < Direction.values().length - 1
                ? Direction.values()[this.ordinal() + 1]
                : Direction.values()[0];
    }
    public Direction turnToRight() {
        return this.ordinal() > 0
                ? Direction.values()[this.ordinal() - 1]
                : Direction.values()[Direction.values().length - 1];
    }


    Direction(int direction) {
        this.directionIndex = direction;
    }
}
