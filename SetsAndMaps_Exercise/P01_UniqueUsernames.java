package SetsAndMaps_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> users = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            users.add(name);
        }
        for (String user : users) {
            System.out.println(user);
        }
    }
}
