package com.projects.cognizant.robot;

public class RobotLocation {
    private int x;
    private int y;
    private Direction direction;

    private RobotLocation(RobotLocation robotLocation) {
        this.x = robotLocation.getX();
        this.y = robotLocation.getY();
        this.direction = robotLocation.getDirection();
    }

    public RobotLocation(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    private void changeTheLocation(int valX, int valY) {
        x = x + valX;
        y = y + valY;
    }

    public RobotLocation getNextLocation() throws RobotException {
        if (direction == null)
            throw new RobotException("Invalid robot direction");

        RobotLocation robotLocation = new RobotLocation(this);
        switch (direction) {
            case NORTH:
                robotLocation.changeTheLocation(0, 1);
                break;
            case EAST:
                robotLocation.changeTheLocation(1, 0);
                break;
            case SOUTH:
                robotLocation.changeTheLocation(0, -1);
                break;
            case WEST:
                robotLocation.changeTheLocation(-1, 0);
                break;
        }
        return robotLocation;
    }
}
