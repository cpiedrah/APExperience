package experience.ap.schedule;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import experience.ap.employee.Employee;

public class Schedule {
    private HashMap<String, Employee> roster;
    private String[][] convertedCSVFile;
    private String selectFile(){
        System.out.println("Enter CSV file path:");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        return userInput;
    }
    private void convertCSVToSchedule(){
        /*String path = "C:\Users\dpiedrah\OneDrive - Wiley\Desktop\Anoop_APE\SampleTextFile.csv";*/
        String path = selectFile();
        String line = "";
        try{
            BufferedReader bR = new BufferedReader(new FileReader(path));
            line = bR.readLine();

            while((line = bR.readLine()) != null){
                String[] arr = line.split(",");
                /*assume the following to be true:
                arr[1] is the first name
                arr[2] is the last name
                arr[3] is the contact information
                arr[4] - arr[10] is Friday - Thursday
                */
                roster.put(arr[1]+arr[2], new Employee(arr));

            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
