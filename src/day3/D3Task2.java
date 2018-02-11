package day3;

/*
Unfortunately I can't take a creation loop from task 1 because here I have to start in order because surrounding fields can be null;
A second 2d array will be filled parallel to calculate the sums.
The numbers of the outer rows and columns will be wrong. But they shouldn't be necessary.
While creating I look for the number > searchNumber < nextNumber.
 */
public class D3Task2 {
    //This is the number you are looking for
    private static int searchNumber = 312051;

    private static Integer [][] matrix;
    private static int[][] sum;
    private  static Integer solution;

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        int size = (int) Math.ceil(Math.sqrt(searchNumber));
        if(size % 2 == 0) size ++;
        //Minimum size needed
        if (size < 7) size = 7 ;

        matrix = new Integer[size][size];
        sum = new int[size][size];

        System.out.println("Size:" + size);

        int center = (int) Math.ceil(size/2);

        System.out.println("Center:" + center);

        int numberCounter = 3;
        int row = center;
        int col = center + 1;

        //Basic settings
        matrix[center][center] = 1;
        matrix[center][center + 1] = 2;
        sum[center][center] = 1;
        calcSum(center, center + 1, size);

        final long beginNumberMap = System.currentTimeMillis();

        //Create the number array
        while(numberCounter < Math.pow(size, 2)){
            //As long as something is above you go right
            while (numberCounter <= Math.pow(size, 2) && matrix[row-1][col] != null ){
                col++;
                matrix[row][col] = numberCounter;
                numberCounter++;
                calcSum(row, col, size);
            }
            //As long as something is left of you go up
            while (numberCounter < Math.pow(size, 2) && matrix[row][col-1] != null){
                row--;
                matrix[row][col] = numberCounter;
                numberCounter++;
                calcSum(row, col, size);
            }
            //As long as something is beneath you go left
            while (numberCounter < Math.pow(size, 2) && matrix[row+1][col] != null){
                col--;
                matrix[row][col] = numberCounter;
                numberCounter++;
                calcSum(row, col, size);
            }
            //As long as something is right of you go down
            while (numberCounter < Math.pow(size, 2) && matrix[row][col+1] != null){
                row++;
                matrix[row][col] = numberCounter;
                numberCounter++;
                calcSum(row, col, size);
            }

        }

        final long endNumberMap = System.currentTimeMillis();

        System.out.println();
        System.out.println("Solution: " + solution);
        System.out.println();
        System.out.println("Process took: " + (endNumberMap - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println("Number Map and calculating: " + (endNumberMap - beginNumberMap) + "ms");
    }

    //Checking matrix if field is null (has value) but using the sum field to add the sums
    private static void calcSum(final int row, final int col, int size){
        int tmpSum = 0;

        //Field left
        if(col > 0 && matrix[row][col-1] != null) tmpSum += sum[row][col-1];
        //Field bottom left
        if(col > 0 && row < size -1 && matrix[row+1][col-1] != null) tmpSum += sum[row+1][col-1];
        //Field bottom
        if(row < size -1 && matrix[row+1][col] != null) tmpSum += sum[row+1][col];
        //Field bottom right
        if(col < size -1 && row < size -1 && matrix[row+1][col+1] != null) tmpSum += sum[row+1][col+1];
        //Field right
        if(col < size -1 && matrix[row][col+1] != null) tmpSum += sum[row][col+1];
        //Field top right
        if(col < size -1 && row > 0 && matrix[row-1][col+1] != null) tmpSum += sum[row-1][col+1];
        //Field top
        if(row > 0 && matrix[row-1][col] != null) tmpSum += sum[row-1][col];
        //Field top left
        if(col > 0 && row > 0 && matrix[row-1][col-1] != null) tmpSum += sum[row-1][col-1];

        sum[row][col] = tmpSum;

        //Look for solution
        //Because its calculated in every step, the first answer is the correct one
        if(solution == null && tmpSum > searchNumber ) {
            //Only special case because set and not calculated
            if(searchNumber == 1) solution = 1;
            else solution = tmpSum;
            if(col == 0 || col == size || row == 0 || row == size) System.out.println("THIS IS A OUTER BOUND SOLUTION AND PROPABLY WRONG, CHANGE THE SIZE OF THE ARRAY");
        }


    }
}
