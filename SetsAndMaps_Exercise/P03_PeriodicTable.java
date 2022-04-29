package SetsAndMaps_Exercise;

import java.util.*;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split("\\s+");
//  1 way          for (String element : split) {
//                set.add(element);
//  2 way          Collections.addAll(Arrays.asList(split,set));
            set.addAll(Arrays.asList(split));
        }
        for (String element : set) {
            System.out.print(element + " ");
        }
    }
}

