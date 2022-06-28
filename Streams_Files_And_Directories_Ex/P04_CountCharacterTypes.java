package Streams_Files_And_Directories_Ex;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String output = "output.txt";

        try (Scanner scanner = new Scanner(new FileReader(path));
             PrintWriter pr = new PrintWriter(new FileOutputStream(output))) {

            int[] count = new int[3];
            String vowels = "aouei";
            String punctuations = ".,!?";

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                Arrays.stream(line.split("\\s+"))
                        .forEach(str -> {
                            for (char symbol : str.toCharArray()) {
                                if (vowels.contains(String.valueOf(symbol))) {
                                    count[0]++;
                                }else if (punctuations.contains(String.valueOf(symbol))){
                                    count[2]++;
                                }else {
                                    count[1]++;
                                }
                            }
                        });

            }
            pr.printf("Vowels: %d%n",count[0]);
            pr.printf("Consonants: %d%n",count[1]);
            pr.printf("Punctuation: %d%n",count[2]);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
