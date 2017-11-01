package com.projects.cognizant.robot;

import static java.util.Objects.requireNonNull;

public class Robot {

    private RobotLocation robotLocation;

    public Robot() {
    }

    public boolean setRobotLocation(RobotLocation robotLocation) {
        requireNonNull(robotLocation);

        this.robotLocation = robotLocation;
        return true;
    }

    public RobotLocation getRobotLocation() {
        return this.robotLocation;
    }

    public boolean turnRobotToLeft() {
        if (robotLocation == null || robotLocation.getDirection() == null)
            return false;

        robotLocation.setDirection(this.robotLocation.getDirection().turnToLeft());
        return true;
    }

    public boolean turnRobotToRight() {
        if (robotLocation == null || robotLocation.getDirection() == null)
            return false;

        robotLocation.setDirection(this.robotLocation.getDirection().turnToRight());
        return true;
    }

}
