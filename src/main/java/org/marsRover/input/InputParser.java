package org.marsRover.input;

import java.util.ArrayList;

public class InputParser {
    public ArrayList<Instruction> parser(String input) {
        char[] inputArray = input.toUpperCase().toCharArray();
        ArrayList<Instruction> parsed = new ArrayList<>();
// TODO: Does this need to parse int values for Plateau and Rover creation?

        for (char c : inputArray) {
            switch (c) {
                case 'L':
                    parsed.add(Instruction.L);
                    break;
                case 'R':
                    parsed.add(Instruction.R);
                    break;
                case 'F':
                    parsed.add(Instruction.F);
                    break;
                case 'B':
                    parsed.add(Instruction.B);
                    break;
            }
        }
        return parsed;
    }


}