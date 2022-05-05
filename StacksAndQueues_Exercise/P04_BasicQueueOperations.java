package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numToAdd = scanner.nextInt();
        int numToPoll = scanner.nextInt();
        int numToFind = scanner.nextInt();
        scanner.nextLine();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numToAdd; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < numToPoll; i++) {
            queue.poll();
        }
        if (queue.contains(numToFind)){
            System.out.println("true");
        }else if (!queue.isEmpty()){
            System.out.println(Collections.min(queue));
        }else System.out.println(0);

    }
}
