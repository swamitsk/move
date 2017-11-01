package com.projects.cognizant;

import com.projects.cognizant.robot.*;

public class RobotMovementHandler {

    Grid rectangularGrid;
    Robot robot;

    public RobotMovementHandler(Grid squareGrid, Robot robot) {
        this.rectangularGrid = squareGrid;
        this.robot = robot;
    }

    private boolean placeTheRobotIn(RobotLocation robotLocation) throws RobotException {

        if (rectangularGrid == null)
            throw new RobotException("Invalid rectangularGrid object");

        if (robotLocation == null)
            throw new RobotException("Invalid robotLocation object");

        if (robotLocation.getDirection() == null)
            throw new RobotException("Invalid direction value");

        if (!rectangularGrid.isValidRobotLocation(robotLocation))
            return false;
        robot.setRobotLocation(robotLocation);
        return true;
    }

    public String performRobotMovementBasedOnInput(String inputString) throws RobotException {
        String[] args = inputString.split(" ");

        RobotMovementCommand robotMovementCommand;
        robotMovementCommand = validatePlaceAction(args);
        String[] params;
        int x = 0;
        int y = 0;
        Direction direction = null;
        if (robotMovementCommand == RobotMovementCommand.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                direction = Direction.valueOf(params[2]);
            } catch (Exception e) {
                throw new RobotException("Invalid robotMovementCommand");
            }
        }

        return performMovementBasedOnAction(robotMovementCommand, x, y, direction);
    }

    private RobotMovementCommand validatePlaceAction(String[] args) throws RobotException {
        RobotMovementCommand robotMovementCommand;
        try {
            robotMovementCommand = RobotMovementCommand.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new RobotException("Invalid robotMovementCommand");
        }
        if (robotMovementCommand == RobotMovementCommand.PLACE && args.length < 2) {
            throw new RobotException("Invalid robotMovementCommand");
        }
        return robotMovementCommand;
    }

    private String performMovementBasedOnAction(RobotMovementCommand robotMovementCommand, int x, int y, Direction commandDirection) throws RobotException {
        switch (robotMovementCommand) {
            case PLACE:
                return String.valueOf(placeTheRobotIn(new RobotLocation(x, y, commandDirection)));
            case MOVE:
                RobotLocation newRobotLocation = robot.getRobotLocation().getNextLocation();
                return !rectangularGrid.isValidRobotLocation(newRobotLocation) ? String.valueOf(false) : String.valueOf(robot.setRobotLocation(newRobotLocation));
            case LEFT:
                return String.valueOf(robot.turnRobotToLeft());
            case RIGHT:
                return String.valueOf(robot.turnRobotToRight());
            case REPORT:
                return getCurrentLocation();
            default:
                throw new RobotException("Invalid robotMovementCommand");
        }
    }

    private String getCurrentLocation() {
        if (robot.getRobotLocation() == null)
            return null;

        return robot.getRobotLocation().getX() + "," + robot.getRobotLocation().getY() + "," + robot.getRobotLocation().getDirection().toString();
    }
}
