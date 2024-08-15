package org.marsRover.logic;

import org.marsRover.input.Direction;
import org.marsRover.input.Instruction;
import org.marsRover.input.Position;

public class Rover {
    private Position currentPosition;

    //TODO: Consider refactoring this because it is some messy code
    //How are we going to pass this data?
    // currently instructions are an array,
    // we will need to iterate to get individual Instructions
    // Would using a for loop with if-statements calling individual methods be better?
    //
//    public void move(Position startPosition, Instruction inst) {
//        if (inst == Instruction.L) {
//            if (startPosition.getFacing() == Direction.N) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.W);
//            } else if (startPosition.getFacing() == Direction.W) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.S);
//            } else if (startPosition.getFacing() == Direction.S) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.E);
//            } else if (startPosition.getFacing() == Direction.E) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.N);
//            }
//        } else if (inst == Instruction.R) {
//            if (startPosition.getFacing() == Direction.N) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.E);
//            } else if (startPosition.getFacing() == Direction.E) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.S);
//            } else if (startPosition.getFacing() == Direction.S) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.W);
//            } else if (startPosition.getFacing() == Direction.W) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.N);
//            }
//
//        } else if (inst == Instruction.M) {
//            if (startPosition.getFacing() == Direction.N) {
//                currentPosition = new Position(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getFacing());
//            } else if (startPosition.getFacing() == Direction.E) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getFacing());
//            } else if (startPosition.getFacing() == Direction.S) {
//                currentPosition = new Position(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getFacing());
//            } else if (startPosition.getFacing() == Direction.W) {
//                currentPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getFacing());
//            }
//        }
//    }
    public Position rotateL(Position startPosition) {
        Position pos = startPosition;
        if (startPosition.getFacing() == Direction.N) {
            pos.setFacing(Direction.W);
        } else if (startPosition.getFacing() == Direction.W) {
            pos.setFacing(Direction.S);
        } else if (startPosition.getFacing() == Direction.S) {
            pos.setFacing(Direction.E);
        } else if (startPosition.getFacing() == Direction.E) {
            pos.setFacing(Direction.N);
        }
        return pos;
    }
    public void rotateR(Position startPosition) {
        if (startPosition.getFacing() == Direction.N) {
            currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.E);
        } else if (startPosition.getFacing() == Direction.E) {
            currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.S);
        } else if (startPosition.getFacing() == Direction.S) {
            currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.W);
        } else if (startPosition.getFacing() == Direction.W) {
            currentPosition = new Position(currentPosition.getX(), currentPosition.getY(), Direction.N);
        }
    }
    public void moveForwards(Position startPosition) {
        if (startPosition.getFacing() == Direction.N) {
            currentPosition = new Position(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getFacing());
        } else if (startPosition.getFacing() == Direction.E) {
            currentPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getFacing());
        } else if (startPosition.getFacing() == Direction.S) {
            currentPosition = new Position(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getFacing());
        } else if (startPosition.getFacing() == Direction.W) {
            currentPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getFacing());
        }
    }
}
