package util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.BitSet;

public class InputReader {

    public static int[][] readInputTo2dArray(final String identifier) throws IOException, URISyntaxException {

        int[][] matrix;
        final int[] rows = {0};
        final ArrayList<Integer> columns = new ArrayList<>();

        BufferedReader buffer = getReader(identifier);

        buffer.lines().forEach(
                line -> {
                    rows[0] += 1;
                    columns.add(line.trim().split("\\s+").length);
                }
        );

        buffer = getReader(identifier);

        matrix = new int[rows[0]][];

        for(int i = 0; i < rows[0]; i++){
            matrix[i] = new int[columns.get(i)];
        }


        for(int i = 0; i < rows[0]; i++){
            String[] values = buffer.readLine().trim().split("\\s+");
            for(int k = 0; k < columns.get(i); k++){
                matrix[i][k] = Integer.parseInt(values[k]);
            }
        }

        buffer.close();

        return matrix;
    }

    public static ArrayList<String> readInputToLArrayList(final String identifier) throws FileNotFoundException, URISyntaxException {
        BufferedReader buffer = getReader(identifier);
        final ArrayList<String> list = new ArrayList<>();

        buffer.lines().forEach(list::add);

        return list;
    }

    private static BufferedReader getReader (final String identifier) throws URISyntaxException, FileNotFoundException {
        File file = new File(InputReader.class.getClassLoader().getResource(identifier).toURI());

        FileReader reader = new FileReader(file);
        return new BufferedReader(reader);
    }
}
