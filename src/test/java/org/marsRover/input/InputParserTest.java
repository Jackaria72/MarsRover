package org.marsRover.input;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
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
        ArrayList<Instruction> testL = testParser.instructionParser("L");
        ArrayList<Instruction> testLLower = testParser.instructionParser("l");
        ArrayList<Instruction> testR = testParser.instructionParser("R");
        ArrayList<Instruction> testRLower = testParser.instructionParser("r");
        ArrayList<Instruction> testF = testParser.instructionParser("F");
        ArrayList<Instruction> testFLower = testParser.instructionParser("f");
        ArrayList<Instruction> testB = testParser.instructionParser("B");
        ArrayList<Instruction> testBLower = testParser.instructionParser("b");
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
        ArrayList<Instruction> test1 = testParser.instructionParser("LLL");
        ArrayList<Instruction> test2 = testParser.instructionParser("LrRF");
        ArrayList<Instruction> test3 = testParser.instructionParser("FRlLr");

        // Assert
        assertAll(

                () -> assertEquals(expected1, test1),
                () -> assertEquals(expected2, test2),
                () -> assertEquals(expected3, test3)
        );

    }
}