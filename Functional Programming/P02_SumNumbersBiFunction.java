package FinctionalProgramming;

import java.util.Scanner;
import java.util.function.BiFunction;

public class P02_SumNumbersBiFunction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");

        System.out.println("Count = "+ input.length);

        BiFunction<Integer,String,Integer> parseAndSum = (x,y)-> x+Integer.parseInt(y);
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = parseAndSum.apply(sum,input[i]);
        }
        System.out.println("Sum = "+sum);
    }
}
