package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        String resource = "";
        while (!"stop".equals(resource=scanner.nextLine())){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!map.containsKey(resource)){
                map.put(resource,quantity);
            }else {
                map.put(resource,map.get(resource)+quantity);
            }
        }
        map.entrySet().forEach(entry ->
                System.out.println(entry.getKey()+" -> "+entry.getValue()));
    }
}
