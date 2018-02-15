package day5;

import util.InputReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class D5Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final long startTime = System.currentTimeMillis();

        List<Integer> input = InputReader.readInputRowsToIntegergArrayList("day5/input");

        final long readerEnd = System.currentTimeMillis();

        Integer pointer = 0;
        Integer counter = 0;

        while (pointer >= 0 && pointer <input.size()){
            Integer curr = input.get(pointer);
            if(curr > 2) input.set(pointer, curr - 1);
            else input.set(pointer, curr + 1);
            pointer += curr;
            counter++;

        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Exit after: " + counter);
        System.out.println();
        System.out.println("Process took: " + (endTime - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println();
        System.out.println("Filereader: " + (readerEnd - startTime) + "ms");
        System.out.println("Calculation: " + (endTime - readerEnd) + "ms");
    }
}
