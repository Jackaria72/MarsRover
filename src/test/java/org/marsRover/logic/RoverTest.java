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
        Rover curiosity = new Rover(new Position(5,5, Direction.N));

        curiosity.rotateL(curiosity.getCurrentPosition());
        Direction result1 = curiosity.getCurrentPosition().getFacing();

        curiosity.rotateL(curiosity.getCurrentPosition());
        Direction result2 = curiosity.getCurrentPosition().getFacing();

        curiosity.rotateL(curiosity.getCurrentPosition());
        Direction result3 = curiosity.getCurrentPosition().getFacing();

        curiosity.rotateL(curiosity.getCurrentPosition());
        Direction result4 = curiosity.getCurrentPosition().getFacing();

        assertEquals(Direction.W,result1);
        assertEquals(Direction.S,result2);
        assertEquals(Direction.E,result3);
        assertEquals(Direction.N,result4);

    }

    @Test
    void rotateR() {
    }

    @Test
    void moveForwards() {
    }
}