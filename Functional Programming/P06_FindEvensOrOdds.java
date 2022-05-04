package FinctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(input[0]);
        int upper = Integer.parseInt(input[1]);
        String evenOdd = scanner.nextLine();


        Predicate<Integer> filter = getFilter(evenOdd);
        Consumer<Integer> print = x -> System.out.print(x + " ");

        IntStream.rangeClosed(lower, upper)
                .boxed()
                .filter(filter)
                .forEach(print);

//        for (int i = lower; i <= upper; i++) {
//            if (filter.test(i)) {
//                System.out.print(i + " ");
//            }
//        }
    }
    public static Predicate<Integer> getFilter(String evenOdd) {
        if (evenOdd.equals("even")) {
            return x -> x % 2 == 0;
        } else {
            return x -> x % 2 != 0;
        }
    }
}
