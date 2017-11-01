package com.projects.cognizant.robot;

public class RectangularGrid implements Grid {

    private int rows;
    private int columns;

    public RectangularGrid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public boolean isValidRobotLocation(RobotLocation robotLocation) {
        return !(
                robotLocation.getX() > columns || robotLocation.getX() < 0 ||
                        robotLocation.getY() > rows || robotLocation.getY() < 0
        );
    }
}
