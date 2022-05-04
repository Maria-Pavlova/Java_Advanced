package FinctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", numbers));

        numbers = numbers.stream()
                .map(Integer::parseInt)
                .sorted()
                .map(Objects::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));
    }
}
