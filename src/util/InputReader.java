package util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class InputReader {

    public static int[][] readInput(final String identifier) throws IOException, URISyntaxException {

        int[][] matrix;
        final int[] rows = {0};
        final ArrayList<Integer> columns = new ArrayList<>();

        File file = new File(InputReader.class.getClassLoader().getResource(identifier).toURI());

        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        buffer.lines().forEach(
                line -> {
                    rows[0] += 1;
                    columns.add(line.trim().split("\\s+").length);
                }
        );

        reader = new FileReader(file);
        buffer = new BufferedReader(reader);

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

        reader.close();
        buffer.close();

        return matrix;
    }
}
