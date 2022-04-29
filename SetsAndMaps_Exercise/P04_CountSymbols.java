package SetsAndMaps_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character,Integer> map = new TreeMap<>();
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!map.containsKey(symbol)){
                map.putIfAbsent(symbol, 1);
            }else {
                map.put(symbol,map.get(symbol)+1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }

    }
}
