package experience.ap.scheduler;

import experience.ap.employee.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Scheduler {
    private ArrayList<Employee> roster;
    private int year, month, day;
    public Scheduler(){
        roster = new ArrayList<Employee>();
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the year? (number)");
        year = scan.nextInt();
        System.out.println("What is the month? (number)");
        month = scan.nextInt();
        System.out.println("What is the day? (number)");
        day = scan.nextInt();
    }
    public static void main(String[] args){
        Scheduler scheduler = new Scheduler();
        scheduler.setRoster(convertCSVToSchedule());
    }
    public int getYear(){return year;}
    public int getMonth(){return month;}
    public int getDay(){return day;}
    public void setYear(int y){year = y;}
    public void setMonth(int m){month = m;}
    public void setDay(int d){day = d;}
    public void setRoster(ArrayList<Employee> tempRoster){roster.addAll(tempRoster);}
    private static String selectFile(){
        System.out.println("Enter CSV file path:");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        return userInput;
    }
    private static ArrayList<Employee> convertCSVToSchedule(){
        /*String path = "C:\Users\dpiedrah\OneDrive - Wiley\Desktop\Anoop_APE\SampleTextFile.csv";*/
        String path = selectFile();
        String line = "";
        try{
            BufferedReader bR = new BufferedReader(new FileReader(path));
            line = bR.readLine();
            ArrayList<Employee> tempRoster = new ArrayList<Employee>();
            while((line = bR.readLine()) != null){
                String[] arr = line.split(",");
                /*assume the following to be true:
                arr[1] is the first name
                arr[2] is the last name
                arr[3] is the contact information
                arr[4] - arr[10] is Friday - Thursday
                */
                tempRoster.add(new Employee(arr));
            }
            return tempRoster;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
