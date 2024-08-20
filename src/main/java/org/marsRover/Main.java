package org.marsRover;

import org.marsRover.input.InputParser;
import org.marsRover.input.Position;
import org.marsRover.logic.Rover;

public class Main {
    public static void main(String[] args) {

/*  TODO: Tie movements to the Plateau

    TODO: add a method to pass parsed input Instructions to the Rover
            (loop through and call appropriate method)

    TODO: Implement separate parser to handle numeric inputs for Plat Init

    TODO: Maybe implement a regex to remove unwanted characters in input (i.e. commas, spaces)
            currently unneeded as it ONLY cares about the Instruction Values

    TODO: If Instruction input contains an incorrect input, what does it do?
            I want it to move up up to the incorrect value and return the unused instructions to user
 */

        InputParser test = new InputParser();
        String roverInit = "5 5 n";

        Position out = test.initParser(roverInit);

        Rover curiosity = new Rover(out);

        System.out.println("X: " + out.getX());
        System.out.println("Y: " + out.getY());
        System.out.println("Facing: " + out.getFacing());

        System.out.println("Curiosity Start");
        System.out.println("X: " + curiosity.getCurrentPosition().getX());
        System.out.println("Y: " + curiosity.getCurrentPosition().getY());
        System.out.println("Facing: " + curiosity.getCurrentPosition().getFacing());

        curiosity.rotateL(curiosity.getCurrentPosition().getFacing());
        Position postMove = curiosity.moveFwd(curiosity.getCurrentPosition().getFacing());

        System.out.println("X: " + postMove.getX());
        System.out.println("Y: " + postMove.getY());
        System.out.println("Facing: " + postMove.getFacing());
    }
}