package org.marsRover.input;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void testParser_singleInputMixedCases() {
        //Arrange
        InputParser testParser = new InputParser();
        ArrayList<Instruction> expectedL = new ArrayList<>(List.of(Instruction.L));
        ArrayList<Instruction> expectedR = new ArrayList<>(List.of(Instruction.R));
        ArrayList<Instruction> expectedM = new ArrayList<>(List.of(Instruction.M));
        //Act
        ArrayList<Instruction> testL = testParser.parser("L");
        ArrayList<Instruction> testLLower = testParser.parser("l");
        ArrayList<Instruction> testR = testParser.parser("R");
        ArrayList<Instruction> testRLower = testParser.parser("r");
        ArrayList<Instruction> testM = testParser.parser("M");
        ArrayList<Instruction> testMLower = testParser.parser("m");
        // Assert
        assertAll(
                () -> assertEquals(expectedL, testL),
                () -> assertEquals(expectedL, testLLower),
                () -> assertEquals(expectedR, testR),
                () -> assertEquals(expectedR, testRLower),
                () -> assertEquals(expectedM, testM),
                () -> assertEquals(expectedM, testMLower)
        );

    }
    @Test
    void testParser_MultiInputMixedCases() {
        //Arrange
        InputParser testParser = new InputParser();
        ArrayList<Instruction> expected1 = new ArrayList<>(List.of(Instruction.L, Instruction.L, Instruction.L));
        ArrayList<Instruction> expected2 = new ArrayList<>(List.of(Instruction.L,Instruction.R, Instruction.R, Instruction.M));
        ArrayList<Instruction> expected3 = new ArrayList<>(List.of(Instruction.M, Instruction.R, Instruction.L, Instruction.L, Instruction.R));
        //Act
        ArrayList<Instruction> test1 = testParser.parser("LLL");
        ArrayList<Instruction> test2 = testParser.parser("LrRM");
        ArrayList<Instruction> test3 = testParser.parser("MRlLr");

        // Assert
        assertAll(

                () -> assertEquals(expected1, test1),
                () -> assertEquals(expected2, test2),
                () -> assertEquals(expected3, test3)
        );

    }
}