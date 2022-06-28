package Streams_Files_And_Directories_Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            int sum = 0;
            while (line != null){
                for (char c: line.toCharArray()){
                    sum += c;
                }
                line= br.readLine();
            }
            System.out.println(sum);
        }
    }
}
