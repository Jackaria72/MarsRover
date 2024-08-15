package org.marsRover.logic;

import org.junit.jupiter.api.Test;
import org.marsRover.input.Direction;
import org.marsRover.input.Position;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

//    @Test
//    void move() {
//    }

    @Test
    void testRotateL() {
        Rover curiosity = new Rover();
        Position testStart = new Position(5,5, Direction.N);

        Position result1 = curiosity.rotateL(testStart);
        String r1 = result1.getFacing().toString();

        String expected1 = Direction.W.name();
        assertEquals(expected1,result1);
    }

    @Test
    void rotateR() {
    }

    @Test
    void moveForwards() {
    }
}