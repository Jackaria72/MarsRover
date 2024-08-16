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
    @Test
    void testInitParseSingleIn() {
        InputParser testParser = new InputParser();

        ArrayList<Object> expectedN = new ArrayList<>(List.of(Direction.N));
        ArrayList<Object> expectedE = new ArrayList<>(List.of(Direction.E));
        ArrayList<Object> expectedS = new ArrayList<>(List.of(Direction.S));
        ArrayList<Object> expectedW = new ArrayList<>(List.of(Direction.W));
        ArrayList<Object> expected1D = new ArrayList<>(List.of(2));
        ArrayList<Object> expected2D = new ArrayList<>(List.of(13));

        ArrayList<Object> resultN = testParser.initParser("n");
        ArrayList<Object> resultS = testParser.initParser("S");
        ArrayList<Object> resultE = testParser.initParser("e");
        ArrayList<Object> resultW = testParser.initParser("W");
        ArrayList<Object> result1D = testParser.initParser("2");
        ArrayList<Object> result2D = testParser.initParser("13");

        assertAll(
                () -> assertEquals(expectedN,resultN),
                () -> assertEquals(expectedE,resultE),
                () -> assertEquals(expectedS,resultS),
                () -> assertEquals(expectedW,resultW),
                () -> assertEquals(expected1D,result1D),
                () -> assertEquals(expected2D,result2D)
        );
    }
    @Test
    void testInitParseMultiIn() {
        InputParser testParser = new InputParser();

        ArrayList<Object> expected1 = new ArrayList<>(List.of(Direction.N, 2, 3));
        ArrayList<Object> expected2 = new ArrayList<>(List.of(Direction.E, 13, 3));
        ArrayList<Object> expected3 = new ArrayList<>(List.of(3, 4, Direction.S));
        ArrayList<Object> expected4 = new ArrayList<>(List.of(3, Direction.W, 53));


        ArrayList<Object> result1 = testParser.initParser("n 2 3");
        ArrayList<Object> result2 = testParser.initParser("e 13 3");
        ArrayList<Object> result3 = testParser.initParser("3 4 s");
        ArrayList<Object> result4 = testParser.initParser("3 W 53");


        assertAll(
                () -> assertEquals(expected1,result1),
                () -> assertEquals(expected2,result2),
                () -> assertEquals(expected3,result3),
                () -> assertEquals(expected4,result4)
        );
    }
}