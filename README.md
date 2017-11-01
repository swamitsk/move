# traversal

This executes the Robot Movement within a given grid, The program takes the input from command line and returns the
success or the failure of the particular command

The intial command must be PLACE, as the robot will be placed in the given cell. Note that, the direction and x y coordinates must be supplied too

There are two sets of test cases one for The Direction and another for the movement of the Robot within the grid


Class Details :

RobotDemo : This contains the main class and this can be directly executed from intellij or Eclipse
RobotMovementHandler : Contains the robot and the corresponding grid, This class takes in the command for the movement and uses other model classes to place the Robot. This also checks the validity of the Positions too
Robot : This contains the robot initializing class which associates the location to a robot
RobotLocation : This the XY axis location for a robot and its corresponding Direction
Direction : The Enum defined to hold the direction of the robots
Grid : A generic interface containing single method for validation of robot position within the grid
RobotMovementCommand : contains the list of command viz., Place, Move, Left, Right, and Report
RectangularGrid : Holding the implementation for Grid
