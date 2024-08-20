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
//
    @Test
    void testRoverInitParse() {
        InputParser testParser = new InputParser();

        String test1 = "3 3 n";
        int test1x = 3;
        int test1y = 3;
        Direction test1F = Direction.N;
        String test2 = "6 8 S";
        int test2x = 6;
        int test2y = 8;
        Direction test2F = Direction.S;
        String test3 = "13 8 E";
        int test3x = 13;
        int test3y = 8;
        Direction test3F = Direction.E;


        Position result1 = testParser.initParser(test1);
        int result1x = result1.getX();
        int result1y = result1.getY();
        Direction result1F = result1.getFacing();
        Position result2 = testParser.initParser(test2);
        int result2x = result2.getX();
        int result2y = result2.getY();
        Direction result2F = result2.getFacing();
        Position result3 = testParser.initParser(test3);
        int result3x = result3.getX();
        int result3y = result3.getY();
        Direction result3F = result3.getFacing();


        assertAll(
                () -> assertEquals(test1x,result1x),
                () -> assertEquals(test1y, result1y),
                () -> assertEquals(test1F,result1F),

                () -> assertEquals(test2x,result2x),
                () -> assertEquals(test2y, result2y),
                () -> assertEquals(test2F,result2F),

                () -> assertEquals(test3x,result3x),
                () -> assertEquals(test3y, result3y),
                () -> assertEquals(test3F,result3F)
        );
    }

}