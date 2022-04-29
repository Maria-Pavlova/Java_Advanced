package Matrix_Exercise;

import java.util.Scanner;

public class P03_DiagolanDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, size);
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < size; i++) {
            sum1 += matrix[i][i];
        }
//        i -> col:
        for (int i = 0; i < size; i++) {
            sum2 += matrix[size - 1 - i][i];
        }
        System.out.println(Math.abs(sum1 - sum2));
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        return matrix;
    }
}
