package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersToPush = scanner.nextInt();
        int numbersToPop = scanner.nextInt();
        int numbersToFind = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <numbersToPush; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
        if (stack.contains(numbersToFind)) {
            System.out.println("true");
        }else if (!stack.isEmpty()) {
            System.out.println(Collections.min(stack));
        }else {
            System.out.println(0);

        }

    }
}
