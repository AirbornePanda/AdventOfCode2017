package day1;

import java.util.*;
import java.util.stream.Collectors;

public class D1Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer sum = 0;
        List<Integer> numbers = scanner.next().chars().boxed().mapToInt(Character::getNumericValue).boxed().collect(Collectors.toList());
        Integer number = numbers.get(numbers.size() - 1);

        for (Integer digit: numbers){
            if (digit.intValue() == number.intValue()) sum += digit;

            number = digit;
        }

        System.out.print("Final sum: " + sum);
    }
}
