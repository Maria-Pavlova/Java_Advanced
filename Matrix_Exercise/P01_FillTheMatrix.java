package Matrix_Exercise;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(input[0]);
        int[][] matrix = new int[size][size];
        if (input[1].equals("A")){
            fillMatrixPatternA(matrix,size);
        }else {
            fillMatrixPatternB(matrix,size);
        }
        printMatrix(matrix,size);
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixPatternB(int[][] matrix, int size) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0){
            for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter++;
                }
            }else {
                for (int row = size-1; row >=0 ; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixPatternA(int[][] matrix, int size) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
            matrix[row][col] = counter++;
            }
        }
        return matrix;
    }
}
