package SetsAndMaps_Exercise;

import java.util.*;

public class P09_UsersLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> logMap = new TreeMap<>();

        String input = "";
        while (!"end".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\s+");
            String ip = split[0].split("=")[1];
            String name = split[2].split("=")[1];

            if (!logMap.containsKey(name)) {
                logMap.put(name, new LinkedHashMap<>() {{
                    put(ip, 1);
                }});
            } else {
                Map<String, Integer> currentMap = logMap.get(name);
                if (currentMap.containsKey(ip)) {
                    int currentTimes = currentMap.get(ip);
                    currentMap.put(ip, currentTimes + 1);
                } else {
                    currentMap.put(ip, 1);
                }
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : logMap.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            LinkedHashMap<String, Integer> entryValue = entry.getValue();
            int countIp = entryValue.size();
            for (Map.Entry<String, Integer> innerEntry : entryValue.entrySet()) {
                countIp--;
                if (countIp < 1) {
                    System.out.print(innerEntry.getKey() + " => " + innerEntry.getValue() + ". ");
                    System.out.println();
                } else {
                    System.out.print(innerEntry.getKey() + " => " + innerEntry.getValue() + ", ");

                }
            }
        }
    }
}
