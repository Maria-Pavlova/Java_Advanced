package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            switch (commandLine[0]) {
                case "1":
                    stack.push(currentText.toString());
                    String toAppend = commandLine[1];
                    currentText.append(toAppend);

                    break;
                case "2":
                    stack.push(currentText.toString());
                    int numToDelete = Integer.parseInt(commandLine[1]);
                    int startIndex = currentText.length() - numToDelete;
                    currentText.delete(startIndex, currentText.length());
                    break;
                case "3":
                    int index = Integer.parseInt(commandLine[1]);
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        currentText = new StringBuilder(stack.pop());
                    }
                    break;

            }
        }
    }
}
