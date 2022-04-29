package SetsAndMaps_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isObtained = false;

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);

        Map<String, Integer> junk = new TreeMap<>();


        while (!isObtained) {
            String[] materials = scanner.nextLine().split("\\s+");

            for (int i = 0; i < materials.length - 1; i += 2) {
                int quantity = Integer.parseInt(materials[i]);
                String regant = materials[i + 1].toLowerCase();

                if (regant.equals("motes") || regant.equals("shards")|| regant.equals("fragments")){
                    keyMaterials.put(regant, keyMaterials.get(regant) + quantity);

                    if (keyMaterials.get(regant) >= 250){
                        keyMaterials.put(regant, keyMaterials.get(regant) - 250);
                        if (regant.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                            isObtained = true;
                            break;

                        } else if (regant.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                            isObtained = true;
                            break;
                        } else {
                            System.out.println("Valanyr obtained!");
                            isObtained = true;
                            break;
                        }
                    }

                } else {
                    if (!junk.containsKey(regant)){
                        junk.put(regant, quantity);

                    } else {
                        junk.put(regant, junk.get(regant) + quantity);
                    }
                }
            }
        }
        keyMaterials.entrySet().stream().sorted((a , b) -> {
            if (b.getValue() - a.getValue() == 0){
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        for(Map.Entry<String, Integer> token : junk.entrySet()){
            System.out.printf("%s: %d%n", token.getKey(), token.getValue());
        }
    }
}
