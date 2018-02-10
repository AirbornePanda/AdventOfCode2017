package day1;

import java.util.*;
import java.util.stream.Collectors;

public class D1Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer sum = 0;
        List<Integer> numbers = scanner.next().chars().boxed().mapToInt(Character::getNumericValue).boxed().collect(Collectors.toList());
        List<Integer> oppositeNumbers = new ArrayList<>(numbers);

        Collections.rotate(oppositeNumbers, oppositeNumbers.size() / 2);

        for (Integer i = 0; i < numbers.size(); i++){
            if(numbers.get(i).intValue() == oppositeNumbers.get(i).intValue()) sum += numbers.get(i);
        }

        System.out.print("Final sum: " + sum);
    }
}
