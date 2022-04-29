package SetsAndMaps_Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> map = new LinkedHashMap<>();
        String name = "";
        while (!"stop".equals(name=scanner.nextLine())){
            String email = scanner.nextLine();
            if (!email.endsWith("uk") && !email.endsWith("us")
                    && !email.endsWith("com")){
                map.put(name,email);
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }
    }
}
