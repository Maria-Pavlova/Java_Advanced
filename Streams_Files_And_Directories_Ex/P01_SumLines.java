package Streams_Files_And_Directories_Ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P01_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null){
                long sum = 0;
                for (char c: line.toCharArray()){
                    sum += c;
                }
                System.out.println(sum);
                line = br.readLine();
            }


        }
    }
}
