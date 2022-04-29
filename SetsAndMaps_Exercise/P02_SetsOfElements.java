package SetsAndMaps_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        int lengthSet1 = scanner.nextInt();
        int lengthSet2 = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < lengthSet1; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set1.add(number);
        }
        for (int i = 0; i < lengthSet2; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set2.add(number);
        }
        for (Integer num : set1) {
            if (set2.contains(num)){
                System.out.print(num + " ");
            }
        }
    }
}
