package com.projects.cognizant.robot;

import com.projects.cognizant.RobotMovementHandler;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RobotMovementHandlerTest {

    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPerformRobotMovementBasedOnInput() throws RobotException {

        RectangularGrid grid = new RectangularGrid(10, 10);
        Robot robot = new Robot();
        RobotMovementHandler handler = new RobotMovementHandler(grid, robot);

        handler.performRobotMovementBasedOnInput("PLACE 0,0,NORTH");
        Assert.assertEquals("0,0,NORTH", handler.performRobotMovementBasedOnInput("REPORT"));

        handler.performRobotMovementBasedOnInput("MOVE");
        handler.performRobotMovementBasedOnInput("RIGHT");
        handler.performRobotMovementBasedOnInput("MOVE");
        Assert.assertEquals("1,1,EAST", handler.performRobotMovementBasedOnInput("REPORT"));

        for (int i = 0; i < 10; i++) {
            handler.performRobotMovementBasedOnInput("MOVE");
        }
        Assert.assertEquals("10,1,EAST", handler.performRobotMovementBasedOnInput("REPORT"));

        for (int i = 0; i < 10; i++) {
            handler.performRobotMovementBasedOnInput("LEFT");
        }
        Assert.assertEquals("10,1,WEST", handler.performRobotMovementBasedOnInput("REPORT"));

        thrown.expect(RobotException.class);
        Assert.assertEquals("Invalid command", handler.performRobotMovementBasedOnInput("WRONG COMMAND"));

    }
}
