package org.marsRover.input;

public class PlateauSize {
    private final int xLength;
    private final int yLength;

    public int getXLength() {
        return xLength;
    }

    public int getYLength() {
        return yLength;
    }

    /*TODO: currently Rover is NOT tied to this in any capacity
       Debate to make this more complicated as currently it is just a max x and y value,
       say we add some rocks to sample how will we dictate what position they are at?
     */
    public PlateauSize(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
    }
}
