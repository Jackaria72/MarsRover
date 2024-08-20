package org.marsRover.logic;

import org.marsRover.input.Direction;
import org.marsRover.input.Instruction;
import org.marsRover.input.Position;

public class Rover {
    private Position currentPosition;

    public Rover(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }


    //How are we going to pass this data?
    // currently instructions are an array,
    // we will need to iterate to get individual Instructions
    // Would use of a for loop with if-statements calling individual methods be better?
    //

    public void rotateL(Direction facing) {
        switch (facing) {
            case N -> currentPosition.setFacing(Direction.W);
            case E -> currentPosition.setFacing(Direction.N);
            case S -> currentPosition.setFacing(Direction.E);
            case W-> currentPosition.setFacing(Direction.S);
        }
    }

    public void rotateR(Direction facing) {
        switch (facing) {
            case N -> currentPosition.setFacing(Direction.E);
            case E -> currentPosition.setFacing(Direction.S);
            case S -> currentPosition.setFacing(Direction.W);
            case W-> currentPosition.setFacing(Direction.N);
        }
    }


    public Position moveFwd(Direction facing) {
        switch (facing) {
            case N -> {
                return new Position(currentPosition.getX(), currentPosition.getY()+1, facing);
            }
            case S -> {
                return new Position(currentPosition.getX(), currentPosition.getY()-1, facing);
            }
            case E -> {
                return new Position(currentPosition.getX()+1, currentPosition.getY(), facing);
            }
            case W -> {
                return new Position(currentPosition.getX()-1, currentPosition.getY(), facing);
            }
            default -> {
                System.out.println("Cannot go this way");
                return currentPosition;
            }
        }
    }
    public Position moveBkw(Direction facing) {
        switch (facing) {
            case N -> {
                return new Position(currentPosition.getX(), currentPosition.getY()-1, facing);
            }
            case S -> {
                return new Position(currentPosition.getX(), currentPosition.getY()+1, facing);
            }
            case E -> {
                return new Position(currentPosition.getX()-1, currentPosition.getY(), facing);
            }
            case W -> {
                return new Position(currentPosition.getX()+1, currentPosition.getY(), facing);
            }
            default -> {
                System.out.println("Cannot go this way");
                return currentPosition;
            }
        }
    }
    //    public void moveF(Direction facing) {
//        switch (facing) {
//            case N -> currentPosition.setY(currentPosition.getY() + 1);
//            case E -> currentPosition.setX(currentPosition.getX() + 1);
//            case S -> currentPosition.setY(currentPosition.getY() - 1);
//            case W -> currentPosition.setX(currentPosition.getX() - 1);
//        }
//    }
}
