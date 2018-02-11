package day3;

public class D3Task1 {
    /*
    This program creates two 2d arrays.
    The first one maps the distances.
    The second one maps the actual numbers and their positions.
    It is not the most beautiful way, but it shows two different ways to create a map for the Manhattan distance.
     */
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        //This is the number you are looking for
        int searchNumber = 312051;

        int size = (int) Math.ceil(Math.sqrt(searchNumber));
        if(size % 2 == 0) size ++;

        int [][] distance = new int[size][size];
        Integer [][] matrix = new Integer[size][size];

        System.out.println("Size:" + size);

        int center = (int) Math.ceil(size/2);

        System.out.println("Center:" + center);

        int solution = 0;

        final long beginDistanceMap = System.currentTimeMillis();

        //Create the distance array
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++){
                distance[i][k] = Math.abs(i - center) + Math.abs(k - center);
            }
        }

        final long endDistanceMap = System.currentTimeMillis();

        int leftCol = 0;
        int rightCol = size -1;
        int upperRow = 0;
        int lowerRow = size -1;

        int numberCounter = (int) Math.pow(size, 2);

        matrix[center][center] = 1;

        final long beginNumberMap = System.currentTimeMillis();

        //Create the number array
        while(numberCounter > 1){
            //Lower row from right to left
            for (int i = size - 1; i >= 0; i-- ){
                if(matrix[lowerRow][i] == null) {
                    matrix[lowerRow][i] = numberCounter;
                    if (numberCounter == searchNumber) solution = distance[lowerRow][i];
                    numberCounter--;
                }
            }

            lowerRow--;

            //Left column from bottom to top
            for (int i = size - 1; i >= 0; i--){
                if(matrix[i][leftCol] == null){
                    matrix[i][leftCol] = numberCounter;
                    if (numberCounter == searchNumber) solution = distance[i][leftCol];
                    numberCounter--;
                }
            }

            leftCol++;

            //Upper row from left to right
            for (int i = 0; i < size; i++){
                if(matrix[upperRow][i] == null) {
                    matrix[upperRow][i] = numberCounter;
                    if (numberCounter == searchNumber) solution = distance[upperRow][i];
                    numberCounter--;
                }
            }

            upperRow++;

            //Right column from top to bottom;
            for (int i = 0; i < size; i++) {
                if (matrix[i][rightCol] == null) {
                    matrix[i][rightCol] = numberCounter;
                    if (numberCounter == searchNumber) solution = distance[i][rightCol];
                    numberCounter--;
                }
            }

            rightCol--;

        }

        final long endNumberMap = System.currentTimeMillis();

        System.out.println();
        System.out.println("Solution: " + solution);
        System.out.println();
        System.out.println("Process took: " + (endNumberMap - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println("Distance Map: " + (endDistanceMap - beginNumberMap) + "ms");
        System.out.println("Number Map: " + (endNumberMap - beginNumberMap) + "ms");
    }

}
