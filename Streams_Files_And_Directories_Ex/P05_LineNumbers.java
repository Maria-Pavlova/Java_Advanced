package Streams_Files_And_Directories_Ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05_LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String out = "output.txt";

        try(Scanner scanner = new Scanner(new FileReader(path));
            PrintWriter pr = new PrintWriter(new FileOutputStream(out))) {

            int count = 1;
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                pr.println(count+". "+line);
                count++;
            }
        }
    }
}
