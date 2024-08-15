package org.marsRover;

import org.marsRover.input.InputParser;

public class Main {
    public static void main(String[] args) {
        InputParser prs = new InputParser();
        System.out.println(prs.parser("LLMR"));
    }
}