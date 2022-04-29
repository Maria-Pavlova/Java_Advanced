package Matrix_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split("[()]+");
        int degrees = Integer.parseInt(split[1]) % 360;

        String input = "";
        ArrayList<String> rowsOfList = new ArrayList<String>();
        int maxSize = 0;
        while (!"END".equals(input = scanner.nextLine())) {
            if (input.length() > maxSize) {
                maxSize = input.length();
            }
            rowsOfList.add(input);
        }
        int rows = rowsOfList.size();
        int cols = maxSize;

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < rowsOfList.get(row).length()) {
                    matrix[row][col] = rowsOfList.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        rotateMatrix(degrees, rows, cols, matrix);

    }
    private static void rotateMatrix(int degrees, int rows, int cols, char[][] matrix) {
        if (degrees == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
