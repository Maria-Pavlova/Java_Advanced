package Matrix_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = readArray(scanner);
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                sum = calculateSubMatrixSum(matrix, row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMaxSubMatrix(matrix,maxRow,maxCol);
    }

    private static void printMaxSubMatrix(int[][] matrix, int maxRow, int maxCol) {
        for (int row = maxRow - 1; row <= maxRow + 1 ; row++) {
            for (int col = maxCol - 1; col <= maxCol + 1 ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateSubMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;
        sum += matrix[row][col];
//       Right
        sum += matrix[row][col + 1];
//        L
        sum += matrix[row][col - 1];
//        up
        sum += matrix[row - 1][col];
//      Down
        sum += matrix[row + 1][col];
//        UpLeft
        sum += matrix[row - 1][col - 1];
//        UpRight
        sum += matrix[row - 1][col + 1];
//        DownLeft
        sum += matrix[row + 1][col - 1];
//        DownRight
        sum += matrix[row + 1][col + 1];

        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
    }
}
