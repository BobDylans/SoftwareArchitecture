package com.Demo.Test02.PipelineFilter;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
@Service
public class Main03 {
    public static void main03(String fileName) throws IOException {
        File inFile = new File("D:\\"+fileName);
        File outFile = new File("D:\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}
