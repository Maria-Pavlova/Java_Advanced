package FinctionalProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02_SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");

        Function<String, Integer> parser = e -> Integer.parseInt(e);

        List<Integer> numbers =
                Arrays.stream(input)
                .map(parser)
                .collect(Collectors.toList());

        int sum = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();


        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);
    }
}
