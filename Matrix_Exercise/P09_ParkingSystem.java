package Matrix_Exercise;

import java.util.Scanner;

public class P09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        boolean[][] matrix = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row][0] = true;

        }
        String input = "";
        while (!"stop".equals(input= scanner.nextLine())){
            String[] split = input.split("\\s+");
            int entryRow = Integer.parseInt(split[0]);
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[0]);

        }
    }
}
