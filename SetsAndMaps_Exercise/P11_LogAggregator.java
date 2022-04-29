package SetsAndMaps_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P11_LogAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> usersTime = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIp = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String ip = tokens[0];
            String name = tokens[1];
            int time = Integer.parseInt(tokens[2]);

            if(!usersTime.containsKey(name)){
                usersTime.put(name, time);
                userIp.put(name, new TreeSet<>(){{add(ip);}});
            }else{
                usersTime.put(name, usersTime.get(name)  + time);
                userIp.get(name).add(ip);
            }
        }

        usersTime.forEach((key, value) ->{

            System.out.println(String.format("%s: %d %s", key, value, userIp.get(key).toString()));

        });

    }
}
