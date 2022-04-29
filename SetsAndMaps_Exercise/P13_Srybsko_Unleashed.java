package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13_Srybsko_Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> venueSingersMap = new LinkedHashMap<>();
        String input = "";
        String regex = "\\b(?<name>[A-Za-z ]+)\\s(?<venue>@[A-Za-z ]+)\\s(?<price>\\d+)\\s(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        while (!"End".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singerName = matcher.group("name");
                String venue0 = matcher.group("venue");
                String venue1 = venue0.substring(1);
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                int amount = price * count;

                if (!venueSingersMap.containsKey(venue1)) {
                    LinkedHashMap<String, Integer> singerMap = new LinkedHashMap<>();
                    singerMap.put(singerName, amount);
                    venueSingersMap.put(venue1, singerMap);
                } else {
                    LinkedHashMap<String, Integer> currentMap = venueSingersMap.get(venue1);
                    if (!currentMap.containsKey(singerName)) {
                        currentMap.put(singerName, amount);
                    } else {
                        currentMap.put(singerName, currentMap.get(singerName) + amount);
                    }
                    venueSingersMap.put(venue1, currentMap);
                }
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : venueSingersMap.entrySet()) {
            System.out.println(entry.getKey());
            LinkedHashMap<String, Integer> value = entry.getValue();
            value.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e ->
                        System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        }
    }
}




