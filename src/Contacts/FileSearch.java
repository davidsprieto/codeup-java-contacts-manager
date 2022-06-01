package Contacts;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileSearch {
    public void parseFile(String fileName, String searchStr) throws IOException {
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr)){
                System.out.println(line);
            }
        }
    }

}