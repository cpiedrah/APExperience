package experience.ap.convertToFile;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class CreateFile {
    public static void createFile(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory you wish to save the file in:");
            String path = scanner.nextLine();
            "C:\Users\dpiedrah\OneDrive - Wiley\Desktop\Anoop_APE"
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
