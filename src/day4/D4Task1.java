package day4;

import util.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class D4Task1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final long startTime = System.currentTimeMillis();
        List<String> input = InputReader.readInputToLStringArrayList("day4/input");
        final long readerEnd = System.currentTimeMillis();

        Integer validLines = 0;

        for (String line: input){
            final List<String> words = new ArrayList<>(Arrays.asList(line.trim().split("\\s+")));
            final Map<String, Integer> map= new HashMap<>();
            Boolean found = false;
            for (String word: words) {
                if(!map.containsKey(word)) map.put(word, null);
                else {
                    found = true;
                    break;
                }
            }
            if(!found) validLines++;
        }

        final long calcEnd = System.currentTimeMillis();

        System.out.println("Valid lines: " + validLines);
        System.out.println();
        System.out.println("Process took: " + (calcEnd - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println();
        System.out.println("Filereader: " + (readerEnd - startTime) + "ms");
        System.out.println("Calculation: " + (calcEnd - readerEnd) + "ms");

    }
}
