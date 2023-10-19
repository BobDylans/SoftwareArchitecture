package com.test.objectOriented;

import com.test.objectOriented.Alphabetizer;
import com.test.objectOriented.Output;
import com.test.objectOriented.Shift;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("D:\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\output.txt");

    }
}
