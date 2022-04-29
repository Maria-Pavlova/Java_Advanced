package Matrix_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        String input = "";
        while (!"END".equals(input = scanner.nextLine())) {
            try {
                String[] command = input.split("\\s+");
                if (!"swap".equals(command[0]) || command.length > 5) {
                    throw new IllegalStateException();
                }
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                printMatrix(matrix);

            } catch (IndexOutOfBoundsException | IllegalStateException exception) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        return dimensions;
    }
}
