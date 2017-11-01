package com.projects.cognizant;

import com.projects.cognizant.robot.*;

import java.util.Scanner;

public class RobotDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RectangularGrid rectangularGrid = new RectangularGrid(10, 10);
        Robot robot = new Robot();
        RobotMovementHandler robotMovementHandler = new RobotMovementHandler(rectangularGrid, robot);

        System.out.println("Select an action for the robot:");
        System.out.println("\'PLACE X,Y(x and y are coordinates in the grid) ,NORTH or SOUTH or EAST or WEST'\n MOVE\n LEFT\n RIGHT\n REPORT\n Q to quit");

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