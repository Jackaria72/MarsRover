package org.marsRover.input;

import java.util.ArrayList;

public class InputParser {
    public ArrayList<Instruction> parser(String input) {
        char[] inputArray = input.toCharArray();
        ArrayList<Instruction> parsed = new ArrayList<>();

            for (int i = 0; i < inputArray.length; i++) {
                if ((inputArray[i] == 'l') || (inputArray[i] == 'L')) {
                    parsed.add(Instruction.L);
                } else if ((inputArray[i] == 'r') || (inputArray[i] == 'R')) {
                    parsed.add(Instruction.R);
                } else if ((inputArray[i] == 'm') || (inputArray[i] == 'M')) {
                    parsed.add(Instruction.M);
                }

            }

        return parsed;
    }
}