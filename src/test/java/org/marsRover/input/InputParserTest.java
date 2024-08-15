package org.marsRover.input;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void testParser_singleinput() {
        //Arrange
        InputParser testParser = new InputParser();
        ArrayList<Instruction> expectedL = new ArrayList<>(List.of(Instruction.L));
        ArrayList<Instruction> expectedR = new ArrayList<>(List.of(Instruction.R));
        ArrayList<Instruction> expectedM = new ArrayList<>(List.of(Instruction.M));
        //Act
        ArrayList<Instruction> testL = testParser.parser("L");
        ArrayList<Instruction> testR = testParser.parser("R");
        ArrayList<Instruction> testM = testParser.parser("M");
        // Assert
        assertAll(
                () -> assertEquals(expectedL, testL),
                () -> assertEquals(expectedR, testR),
                () -> assertEquals(expectedM, testM)
        );

    }
}