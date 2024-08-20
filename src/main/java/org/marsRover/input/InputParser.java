package org.marsRover.input;

import java.util.ArrayList;

public class InputParser {

    public ArrayList<Instruction> instructionParser(String input) {
        char[] inputArray = input.toUpperCase().toCharArray();
        ArrayList<Instruction> parsed = new ArrayList<>();

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

    public Position initParser(String input) {
        ArrayList<Integer> num = new ArrayList<>();
        String[] inputArray = input.toUpperCase().split(" ");
        if (inputArray.length != 3) {
            System.out.println("Incorrect number of commands supplied");
        }
        if (!inputArray[0].matches("\\d+")) {
            System.out.println("Illegal input pls try again");
        }
        if (!inputArray[1].matches("\\d+")) {
            System.out.println("Illegal input pls try again");
        }
        if (!inputArray[2].matches("[NSEW]")) {
            System.out.println("Illegal input pls try again");
        }

        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        Direction facing = switch (inputArray[2]) {
            case "N" -> Direction.N;
            case "E" -> Direction.E;
            case "S" -> Direction.S;
            case "W" -> Direction.W;
            default -> throw new IllegalStateException("Unexpected value: " + inputArray[2]);
        };
        return new Position(x,y,facing);
    }




//    public ArrayList<Object> initParser(String input) {
//        ArrayList<Object> output = new ArrayList<>();
//        String[] inputArray = input.toUpperCase().split(" ");
//        for (String in :inputArray) {
//            switch (in){
//                case "N":
//                    output.add(Direction.N);
//                    break;
//                case "E":
//                    output.add(Direction.E);
//                    break;
//                case "S":
//                    output.add(Direction.S);
//                    break;
//                case "W":
//                    output.add(Direction.W);
//                    break;
//                default:
//                    if (in.matches("\\d+")) {
//                        output.add(Integer.valueOf(in));
//                    }
//            }
//        }
//        return output;
//    }
}