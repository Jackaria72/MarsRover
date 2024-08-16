package org.marsRover.input;

import java.util.ArrayList;

public class InputParser {
    public ArrayList<Instruction> parser(String input) {
        char[] inputArray = input.toCharArray();
        ArrayList<Instruction> parsed = new ArrayList<>();
// TODO: Refactor this to switch-case, Does this need to parse int values for Plateau and Rover creation?

            for (int i = 0; i < inputArray.length; i++) {
                if ((inputArray[i] == 'l') || (inputArray[i] == 'L')) {
                    parsed.add(Instruction.L);
                } else if ((inputArray[i] == 'r') || (inputArray[i] == 'R')) {
                    parsed.add(Instruction.R);
                } else if ((inputArray[i] == 'm') || (inputArray[i] == 'M')) {
                    parsed.add(Instruction.M);
                } else {
                    //Works for now to not accept invalid inputs, however this will end the program not ideal
                    throw new RuntimeException("Your Input contained invalid characters, please try again");
                }

            }

        return parsed;
    }


}