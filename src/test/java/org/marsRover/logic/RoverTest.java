package org.marsRover.logic;

import org.junit.jupiter.api.Test;
import org.marsRover.input.Direction;
import org.marsRover.input.Position;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
        /*TODO: test ideas:
                           -: Combination of move and rotates: does it get to end location?

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
        Rover curiosityN = new Rover(new Position(5,5, Direction.N));
        Rover curiosityS = new Rover(new Position(5,5,Direction.S));
        Rover curiosityE = new Rover(new Position(5,5,Direction.E));
        Rover curiosityW = new Rover(new Position(5,5,Direction.W));

        curiosityN.rotateL(curiosityN.getCurrentPosition());
        curiosityS.rotateL(curiosityS.getCurrentPosition());
        curiosityE.rotateL(curiosityE.getCurrentPosition());
        curiosityW.rotateL(curiosityW.getCurrentPosition());


        Direction resultCN = curiosityN.getCurrentPosition().getFacing();
        Direction resultCS = curiosityS.getCurrentPosition().getFacing();
        Direction resultCE = curiosityE.getCurrentPosition().getFacing();
        Direction resultCW = curiosityW.getCurrentPosition().getFacing();

        assertEquals(Direction.W,resultCN);
        assertEquals(Direction.E,resultCS);
        assertEquals(Direction.N,resultCE);
        assertEquals(Direction.S,resultCW);

    }

    @Test
    void testRotateR() {
        Rover curiosityN = new Rover(new Position(5,5, Direction.N));
        Rover curiosityS = new Rover(new Position(5,5,Direction.S));
        Rover curiosityE = new Rover(new Position(5,5,Direction.E));
        Rover curiosityW = new Rover(new Position(5,5,Direction.W));

        curiosityN.rotateR(curiosityN.getCurrentPosition());
        curiosityS.rotateR(curiosityS.getCurrentPosition());
        curiosityE.rotateR(curiosityE.getCurrentPosition());
        curiosityW.rotateR(curiosityW.getCurrentPosition());


        Direction resultCN = curiosityN.getCurrentPosition().getFacing();
        Direction resultCS = curiosityS.getCurrentPosition().getFacing();
        Direction resultCE = curiosityE.getCurrentPosition().getFacing();
        Direction resultCW = curiosityW.getCurrentPosition().getFacing();

        assertEquals(Direction.E,resultCN);
        assertEquals(Direction.W,resultCS);
        assertEquals(Direction.S,resultCE);
        assertEquals(Direction.N,resultCW);
    }

    @Test
    void testMoveForwards() {
        Rover curiosityN = new Rover(new Position(5,5, Direction.N));
        Rover curiosityS = new Rover(new Position(5,5,Direction.S));
        Rover curiosityE = new Rover(new Position(5,5,Direction.E));
        Rover curiosityW = new Rover(new Position(5,5,Direction.W));

        curiosityN.moveF(curiosityN.getCurrentPosition().getFacing());
        curiosityS.moveF(curiosityS.getCurrentPosition().getFacing());
        curiosityE.moveF(curiosityE.getCurrentPosition().getFacing());
        curiosityW.moveF(curiosityW.getCurrentPosition().getFacing());


        int resultCN = curiosityN.getCurrentPosition().getY();
        int resultCS = curiosityS.getCurrentPosition().getY();
        int resultCE = curiosityE.getCurrentPosition().getX();
        int resultCW = curiosityW.getCurrentPosition().getX();

        assertAll(
                () -> assertEquals(6,resultCN),
                () -> assertEquals(4,resultCS),
                () -> assertEquals(6,resultCE),
                () -> assertEquals(4,resultCW)
        );
    }
    @Test
    void testMoveForwardsNonMatchingXYPositions() {
        Rover curiosityN = new Rover(new Position(3,7, Direction.N));
        Rover curiosityS = new Rover(new Position(3,7,Direction.S));
        Rover curiosityE = new Rover(new Position(3,7,Direction.E));
        Rover curiosityW = new Rover(new Position(3,7,Direction.W));

        curiosityN.moveF(curiosityN.getCurrentPosition().getFacing());
        curiosityS.moveF(curiosityS.getCurrentPosition().getFacing());
        curiosityE.moveF(curiosityE.getCurrentPosition().getFacing());
        curiosityW.moveF(curiosityW.getCurrentPosition().getFacing());


        int resultCN = curiosityN.getCurrentPosition().getY();
        int resultCS = curiosityS.getCurrentPosition().getY();
        int resultCE = curiosityE.getCurrentPosition().getX();
        int resultCW = curiosityW.getCurrentPosition().getX();

        assertAll(
                () -> assertEquals(8,resultCN),
                () -> assertEquals(6,resultCS),
                () -> assertEquals(4,resultCE),
                () -> assertEquals(2,resultCW)
        );
    }
}