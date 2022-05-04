package FinctionalProgramming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(",\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            map.put(name, age);
        }
            String olderOrYounger = scanner.nextLine();
            int limitAge = Integer.parseInt(scanner.nextLine());
            String printType = scanner.nextLine();

        BiPredicate<Integer,Integer> filterPredicate;
            if (olderOrYounger.equals("younger")){
                filterPredicate = (age,checkAge)-> age <= checkAge;
            }else {
                filterPredicate = (age,checkAge)-> age >= checkAge;
            }

//        Consumer<Map.Entry<String,Integer>> printConsumer;
//            if (printType.equals("age")){
//                printConsumer = age -> System.out.println(age);
//            }else if (printType.equals("name")){
//
//            }else {
//
//            }

//
//            map.entrySet().stream()
//                    .filter(person -> filterPredicate.test())
//                    .forEach(person-> printConsumer);
//

    }
}
