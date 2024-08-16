package org.marsRover.logic;

import org.junit.jupiter.api.Test;
import org.marsRover.input.Direction;
import org.marsRover.input.Position;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
        /*TODO: test ideas:
                           -: Combination of move and rotates: does it get to end location?
                           -: refactor rotateL and rotateR to match move possibly do before thing to set up rovers
         */
    @Test
    void testRoverInit() {
        Rover curiosity = new Rover(new Position(5,5,Direction.N));

        int xResult = curiosity.getCurrentPosition().getX();
        int yResult = curiosity.getCurrentPosition().getY();
        Direction faceResult = curiosity.getCurrentPosition().getFacing();

        assertAll(
                () -> assertEquals(5,xResult),
                () -> assertEquals(5,yResult),
                () -> assertEquals(Direction.N,faceResult)
        );
    }

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
    void testRotateR() {
        Rover curiosity = new Rover(new Position(5,5, Direction.N));

        curiosity.rotateR(curiosity.getCurrentPosition());
        Direction result1 = curiosity.getCurrentPosition().getFacing();

        curiosity.rotateR(curiosity.getCurrentPosition());
        Direction result2 = curiosity.getCurrentPosition().getFacing();

        curiosity.rotateR(curiosity.getCurrentPosition());
        Direction result3 = curiosity.getCurrentPosition().getFacing();

        curiosity.rotateR(curiosity.getCurrentPosition());
        Direction result4 = curiosity.getCurrentPosition().getFacing();

        assertEquals(Direction.E,result1);
        assertEquals(Direction.S,result2);
        assertEquals(Direction.W,result3);
        assertEquals(Direction.N,result4);
    }

    @Test
    void testMoveForwards() {
        Rover curiosityN = new Rover(new Position(5,5, Direction.N));
        Rover curiosityS = new Rover(new Position(5,5,Direction.S));
        Rover curiosityE = new Rover(new Position(5,5,Direction.E));
        Rover curiosityW = new Rover(new Position(5,5,Direction.W));

        curiosityN.moveForwards(curiosityN.getCurrentPosition());
        curiosityS.moveForwards(curiosityS.getCurrentPosition());
        curiosityE.moveForwards(curiosityE.getCurrentPosition());
        curiosityW.moveForwards(curiosityW.getCurrentPosition());


        int resultCN = curiosityN.getCurrentPosition().getX();
        int resultCS = curiosityS.getCurrentPosition().getX();
        int resultCE = curiosityE.getCurrentPosition().getY();
        int resultCW = curiosityW.getCurrentPosition().getY();

        assertAll(
                () -> assertEquals(6,resultCN),
                () -> assertEquals(4,resultCS),
                () -> assertEquals(6,resultCE),
                () -> assertEquals(4,resultCW)
        );
    }
}