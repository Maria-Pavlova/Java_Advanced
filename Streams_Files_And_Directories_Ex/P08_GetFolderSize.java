package Streams_Files_And_Directories_Ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class P08_GetFolderSize {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
String out = "output.txt";

        try(PrintWriter pr = new PrintWriter(new FileOutputStream(out))) {
            File files = new File(path);
            int size = 0;
            if (files.exists()){
                for (File file : files.listFiles()) {
                    if (file.isFile()){
                        size += file.length();
                    }
                }
            }
            pr.println("Folder size: " + size);
//            System.out.printf("Folder size: %d",size);
        }



    }
}
