package com.projects.cognizant;

import com.projects.cognizant.robot.*;

import java.util.Scanner;

public class RobotDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (scanner == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        RectangularGrid rectangularGrid = new RectangularGrid(10, 5);
        Robot robot = new Robot();
        RobotMovementHandler robotMovementHandler = new RobotMovementHandler(rectangularGrid, robot);

        System.out.println("Select an action for the robot:");
        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or Q");

        while (true) {
            String inputString = scanner.nextLine();
            if ("Q".equals(inputString)) {
                break;
            } else {
                try {
                    String outputVal = robotMovementHandler.performRobotMovementBasedOnInput(inputString);
                    System.out.println(outputVal);
                } catch (RobotException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}