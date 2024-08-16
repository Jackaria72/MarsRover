package org.marsRover.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeTest {

    @Test
    void testPlateauInit() {
        PlateauSize galeCrater = new PlateauSize(10,10);

        int xResult = galeCrater.getXLength();
        int yResult = galeCrater.getYLength();

        assertAll(
                () -> assertEquals(10,xResult),
                () -> assertEquals(10,yResult)
        );
    }

}