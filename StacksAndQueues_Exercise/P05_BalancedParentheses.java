package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char top = stack.pop();
                if (!(symbol == ')' && top == '('
                        || symbol == ']' && top == '['
                        || symbol == '}' && top == '{')) {
                    isBalanced = false;
                    break;
                }
            }
        }
        String output = isBalanced ? "YES" : "NO";
        System.out.println(output);
    }
}

