package SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> mapOfCountry = new LinkedHashMap<>();
        Map<String, Long> countryPopulation = new LinkedHashMap<>();
        String input = "";
        while (!"report".equals(input = scanner.nextLine())) {
            String[] split = input.split("\\|");
            String country = split[1];
            String city = split[0];
            long population = Long.parseLong((split[2]));

            if (!mapOfCountry.containsKey(country)){
                mapOfCountry.put(country, new LinkedHashMap<>());
                countryPopulation.put(country, 0L);
            }
            countryPopulation.put(country, countryPopulation.get(country) + population);

            if (!mapOfCountry.get(country).containsKey(city)) {
                mapOfCountry.get(country).put(city,population);
            }
        }

            mapOfCountry.entrySet().stream()
                    .sorted((e1, e2) -> countryPopulation.get(e2.getKey())
                            .compareTo(countryPopulation.get(e1.getKey())))
                    .forEach(entry -> {
                        System.out.printf("%s (total population: %d)%n", entry.getKey()
                                , countryPopulation.get(entry.getKey()));

                        entry.getValue().entrySet().stream()
                                .sorted( ( a,b)-> b.getValue().compareTo(a.getValue()))
                                .forEach(e -> {
                                    System.out.printf("=>%s: %d%n", e.getKey(), e.getValue());
                                });
                    });

    }
}
