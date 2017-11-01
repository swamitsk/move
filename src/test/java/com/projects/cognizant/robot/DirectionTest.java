package com.projects.cognizant.robot;

import org.junit.Assert;
import org.junit.Test;


public class DirectionTest {

    @Test
    public void testRotate() throws Exception {
        Direction direction = Direction.EAST;

        direction = direction.turnToLeft();
        Assert.assertEquals(direction, Direction.NORTH);

        direction = direction.turnToLeft();
        Assert.assertEquals(direction, Direction.WEST);

        direction = direction.turnToLeft();
        Assert.assertEquals(direction, Direction.SOUTH);

        direction = direction.turnToLeft();
        Assert.assertEquals(direction, Direction.EAST);

        direction = direction.turnToLeft();
        Assert.assertEquals(direction, Direction.NORTH);

        direction = direction.turnToRight();
        Assert.assertEquals(direction, Direction.EAST);

        direction = direction.turnToRight();
        Assert.assertEquals(direction, Direction.SOUTH);

        direction = direction.turnToRight();
        Assert.assertEquals(direction, Direction.WEST);
    }
}
