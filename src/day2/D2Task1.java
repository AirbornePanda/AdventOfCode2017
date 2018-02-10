package day2;

import util.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class D2Task1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final long startTime = System.currentTimeMillis();
        int[][] input = InputReader.readInput("day2/input");
        final long fileReaderEndTime = System.currentTimeMillis();

        final Integer[] high = {null};
        final Integer[] low = {null};
        final Integer[] sum = {0};

        Arrays.stream(input).forEach(
                line -> {
                    Arrays.stream(line).forEach(
                            entry -> {
                                if (high[0] == null || high[0] < entry) high[0] = entry;
                                if (low[0] == null || low[0] > entry) low[0] = entry;
                            }
                    );

                    sum[0] += high[0] - low[0];
                    high[0] = low[0] = null;
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
