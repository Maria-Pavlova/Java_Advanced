package Streams_Files_And_Directories_Ex;

import java.io.*;

public class P03_AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String output = "output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter pr = new PrintWriter(new FileOutputStream(output))) {

            String line = br.readLine();
            while (line != null) {
                pr.println(line.toUpperCase());
                line = br.readLine();
            }

        }
    }
}
