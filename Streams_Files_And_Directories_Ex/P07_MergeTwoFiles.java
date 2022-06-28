package Streams_Files_And_Directories_Ex;

import java.io.*;

public class P07_MergeTwoFiles {
    public static void main(String[] args) {

        String path1 = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String path2 = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String out = "output.txt";

        try (BufferedReader br1 = new BufferedReader(new FileReader(path1));
            BufferedReader br2 = new BufferedReader(new FileReader(path2));
             PrintWriter pr = new PrintWriter(new FileOutputStream(out))){
            String line1 = br1.readLine();
            while (line1 != null){
                pr.println(line1);
               line1 = br1.readLine();
            }
            String line2 = br2.readLine();
            while (line2 != null){
                pr.println(line2);
               line2= br2.readLine();
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
