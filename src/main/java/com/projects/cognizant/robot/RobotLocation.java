package com.projects.cognizant.robot;

public class RobotLocation {
    private int x;
    private int y;
    Direction direction;

    public RobotLocation(RobotLocation robotLocation) {
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void changeTheLocation(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public RobotLocation getNextLocation() throws RobotException {
        if (this.direction == null)
            throw new RobotException("Invalid robot direction");

        RobotLocation robotLocation = new RobotLocation(this);
        switch (this.direction) {
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
