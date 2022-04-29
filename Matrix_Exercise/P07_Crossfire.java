package Matrix_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        ArrayList<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String input = "";
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\s+");
            int rowToFire = Integer.parseInt(split[0]);
            int colToFire = Integer.parseInt(split[1]);
            int radius = Integer.parseInt(split[2]);

            for (int row = rowToFire - radius; row <= rowToFire + radius; row++) {
                if (isInMatrix(row, colToFire, matrix)) {
                    matrix.get(row).remove(colToFire);
                }
            }
            for (int col = colToFire + radius; col >= colToFire - radius; col--) {
                if (isInMatrix(rowToFire, col, matrix)) {
                    matrix.get(rowToFire).remove(col);
                }
            }
            matrix.removeIf(List::isEmpty);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(int row, int col, ArrayList<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size()
                && col >= 0 && col < matrix.get(row).size();
    }


    private static void fillMatrix(ArrayList<List<Integer>> matrix, int rows, int cols) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
    }
}
