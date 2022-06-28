package Streams_Files_And_Directories_Ex;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class P06_WordCount {
    public static void main(String[] args) throws IOException {

        String wordPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String textPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        String out = "results.txt";

        try (BufferedReader wordReader = new BufferedReader(new FileReader(wordPath));
             BufferedReader textReader = new BufferedReader(new FileReader(textPath));
             PrintWriter pr = new PrintWriter(new FileOutputStream(out))) {

            String[] words = wordReader.readLine().split("\\s+");
            Map<String,Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word,0);
            }
            String[] text = textReader.readLine().split("\\s+");
            for (String textWord : text) {
                if (map.containsKey(textWord)){
                    map.put(textWord,map.get(textWord)+1);
                }
            }
            map.entrySet().stream()
                    .sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e-> pr.printf("%s - %d%n",e.getKey(),e.getValue()));
        }


    }
}
