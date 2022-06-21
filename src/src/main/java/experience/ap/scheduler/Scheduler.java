package experience.ap.scheduler;

import experience.ap.employee.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Scheduler {
    private ArrayList<Employee> roster;
    private ArrayList<String> unscheduledDays;
    private HashMap<String, ArrayList<Employee>> dailyRoster;
    public Scheduler(){
        roster = new ArrayList<Employee>();
        unscheduledDays.add("Friday");
        unscheduledDays.add("Saturday");
        unscheduledDays.add("Sunday");
        unscheduledDays.add("Monday");
        unscheduledDays.add("Tuesday");
        unscheduledDays.add("Wednesday");
        unscheduledDays.add("Thursday");
    }
    public static void main(String[] args){
        Scheduler scheduler = new Scheduler();
        scheduler.setRoster(convertCSVToSchedule());
        String dayToFill = scheduler.calcLeastAvailDay();
    }
    public void setRoster(ArrayList<Employee> tempRoster){roster.addAll(tempRoster);}
    public ArrayList<Employee> getRoster(){return roster;}
    public ArrayList<String> getUnscheduledDays(){return unscheduledDays;}
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
        ArrayList<Employee> tempRoster = new ArrayList<Employee>();
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
                tempRoster.add(new Employee(arr));
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return tempRoster;
    }
    public void fillDailyRoster(){
        String[] listOfDays = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        for(int i = 0; i < listOfDays.length; i++){
            ArrayList<Employee> availEmpsForDay = new ArrayList<Employee>();
            for(int j = 0; j < roster.size(); j++){
                if (roster.get(j).getSPD(listOfDays[i]) > 0){
                    availEmpsForDay.add(roster.get(j));
                }
            }
            dailyRoster.put(listOfDays[i], availEmpsForDay);
        }
    }

    private String calcLeastAvailDay(){
        if(unscheduledDays.size() > 0){
            String lowestDay = unscheduledDays.get(0);
            int leastEmpCount = dailyRoster.get(lowestDay).size();
            for (int i = 1; i < unscheduledDays.size(); i++) {
                if (dailyRoster.get(lowestDay).size() < leastEmpCount) {
                    lowestDay = unscheduledDays.get(i);
                    leastEmpCount = dailyRoster.get(unscheduledDays.get(i)).size();
                }
            }
            return lowestDay;
        }
    }

}
