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
        ArrayList<Instruction> expectedF = new ArrayList<>(List.of(Instruction.F));
        ArrayList<Instruction> expectedB = new ArrayList<>(List.of(Instruction.B));
        //Act
        ArrayList<Instruction> testL = testParser.parser("L");
        ArrayList<Instruction> testLLower = testParser.parser("l");
        ArrayList<Instruction> testR = testParser.parser("R");
        ArrayList<Instruction> testRLower = testParser.parser("r");
        ArrayList<Instruction> testF = testParser.parser("F");
        ArrayList<Instruction> testFLower = testParser.parser("f");
        ArrayList<Instruction> testB = testParser.parser("B");
        ArrayList<Instruction> testBLower = testParser.parser("b");
        // Assert
        assertAll(
                () -> assertEquals(expectedL, testL),
                () -> assertEquals(expectedL, testLLower),
                () -> assertEquals(expectedR, testR),
                () -> assertEquals(expectedR, testRLower),
                () -> assertEquals(expectedF, testF),
                () -> assertEquals(expectedF, testFLower),
                () -> assertEquals(expectedB, testB),
                () -> assertEquals(expectedB, testBLower)
        );

    }
    @Test
    void testParser_MultiInputMixedCases() {
        //Arrange
        InputParser testParser = new InputParser();
        ArrayList<Instruction> expected1 = new ArrayList<>(List.of(Instruction.L, Instruction.L, Instruction.L));
        ArrayList<Instruction> expected2 = new ArrayList<>(List.of(Instruction.L,Instruction.R, Instruction.R, Instruction.F));
        ArrayList<Instruction> expected3 = new ArrayList<>(List.of(Instruction.F, Instruction.R, Instruction.L, Instruction.L, Instruction.R));
        //Act
        ArrayList<Instruction> test1 = testParser.parser("LLL");
        ArrayList<Instruction> test2 = testParser.parser("LrRF");
        ArrayList<Instruction> test3 = testParser.parser("FRlLr");

        // Assert
        assertAll(

                () -> assertEquals(expected1, test1),
                () -> assertEquals(expected2, test2),
                () -> assertEquals(expected3, test3)
        );

    }
}