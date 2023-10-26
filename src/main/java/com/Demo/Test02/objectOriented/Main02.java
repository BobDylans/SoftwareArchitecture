package com.Demo.Test02.objectOriented;

import org.springframework.stereotype.Service;

@Service
public class Main02 {
    public void main02(String fileName) {
        Input input = new Input();
        input.input("D:\\"+fileName);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\output.txt");

    }
}
