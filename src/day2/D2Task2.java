package day2;

import util.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class D2Task2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final long startTime = System.currentTimeMillis();
        int[][] input = InputReader.readInput("day2/input");
        final long fileReaderEndTime = System.currentTimeMillis();

        final Integer[] sum = {0};

        Arrays.stream(input).forEach(
                line -> {
                    Integer i = 0;
                    Boolean found = false;
                    while (i < line.length && !found) {
                        for (int entry : line) {
                            if (line[i] != entry && line[i] > entry) {
                                if (line[i] % entry == 0) {
                                    found = true;
                                    sum[0] += line[i] / entry;
                                }
                            }

                        }
                        i++;
                    }
                }
        );

        final long endTime = System.currentTimeMillis();

        System.out.println();
        System.out.println("Total sum: " + sum[0]);
        System.out.println();
        System.out.println("Process took: " + (endTime - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println();
        System.out.println("Filereader: " + (fileReaderEndTime - startTime) + "ms");
        System.out.println("Calculation: " + (endTime - fileReaderEndTime) + "ms");
    }
}
