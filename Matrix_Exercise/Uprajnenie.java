package Matrix_Exercise;

import java.util.Scanner;

public class Uprajnenie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        int sum = 0;
        for (int row = -1; row <= row+1; row++) {
            for (int col = -1; col <= col + 1; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);

    }
}
