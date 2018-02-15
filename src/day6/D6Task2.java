package day6;

import util.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

//Nearly the Same as Task 1
public class D6Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final long startTime = System.currentTimeMillis();

        final List<Integer> input = InputReader.readInputColumnsToIntegergArrayList("day6/input");

        final long readerEnd = System.currentTimeMillis();

        final List<List<Integer>> snapshots = new ArrayList<>();
        Integer count = 0;
        Integer number = 0;
        Integer position = 0;
        Integer loopSize = null;
        AtomicReference<Boolean> found = new AtomicReference<>(false);

        while (!found.get()){
            snapshots.add(new ArrayList<>(input));
            position = findPosition(input);
            number = input.get(position);
            input.set(position, 0);
            count++;

            while (number > 0) {
                if (position == input.size() -1) position = 0;
                else position++;

                input.set(position, input.get(position) + 1);
                number--;
            }

            for(int l = 0; l < snapshots.size(); l++) {
                Boolean foundAll = true;
                List<Integer> list = snapshots.get(l);
                if(found.get()) break;
                for(int i = 0; i < list.size(); i++) {
                    if (!list.get(i).equals(input.get(i))) foundAll = false;
                }
                if(foundAll) {
                    found.set(true);
                    loopSize = count - l;
                    break;
                }
            }
        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Found after: " + count);
        System.out.println();
        System.out.println("Loopsize: " + loopSize);
        System.out.println();
        System.out.println("Process took: " + (endTime - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println();
        System.out.println("Filereader: " + (readerEnd - startTime) + "ms");
        System.out.println("Calculation: " + (endTime - readerEnd) + "ms");


    }

    //Finds the position of the list with the biggest value
    private static Integer findPosition (final List<Integer> list) {
        Integer position = null;
        Integer max = null;

        for (int i = 0; i < list.size(); i++){
            if (position == null || list.get(i) > max) {
                position = i;
                max = list.get(i);
            }
        }

        return position;
    }
}
