package org.marsRover.input;

import java.util.ArrayList;

public class InputParser {

    public ArrayList<Instruction> instructionParser(String input) {
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

    //INIT parser, Needs to take digits, use split to split by a regex?
    //Needs Direction for Rover, what kind of list could take both and be typesafe?
    //Also Needs to convert string input to int
    public ArrayList<Object> initParser(String input) {
        ArrayList<Object> output = new ArrayList<>();
        String[] inputArray = input.toUpperCase().split(" ");
        for (String in :inputArray) {
            switch (in){
                case "N":
                    output.add(Direction.N);
                    break;
                case "E":
                    output.add(Direction.E);
                    break;
                case "S":
                    output.add(Direction.S);
                    break;
                case "W":
                    output.add(Direction.W);
                    break;
                default:
                    if (in.matches("\\d+")) {
                        output.add(Integer.valueOf(in));
                    }
            }
        }
        return output;
    }

}