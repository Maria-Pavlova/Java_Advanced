package SetsAndMaps_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneMap = new HashMap<>();
        String data = "";
        while (!"search".equals(data = scanner.nextLine())) {
            String[] split =data.split("-");
            String name = split[0];
            String phoneNum = split[1];

            phoneMap.put(name, phoneNum);
        }
        String searchName = "";
        while (!"stop".equals(searchName = scanner.nextLine())) {
            if (phoneMap.containsKey(searchName)) {
                System.out.printf("%s -> %s%n", searchName, phoneMap.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
        }
    }
}
