package experience.ap.employee;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
@SuppressWarnings("FieldCanBeLocal")

public class Employee {
    //name will be the way to refer to the employee
    //on the Excel file at the end
    private String name;
    //phone number is for the convenience of the boss
    //for the end result of the project
    private String phoneNumber;
    //availSchedule is when the employee is available to work
    //This takes the key (dayOfWeek - String) and returns an
    //arrayList of Shift objects according to when they are free
    private HashMap<String, String[]> availSchedule;
    private int daysPerWeek;
    //Key: String - dayOfWeek
    //Value: Integer numAvailShifts
    private HashMap<String, Integer> shiftsPerDay;
    private int numShiftsAssigned;
    //args-constructor so only full people can be created
    //incomplete Employees will disrupt the future code
    public Employee(String[] arr){
        name = arr[1] + arr[2];
        phoneNumber = arr[3];
        //need to create a way to read in an Excel Sheet and fill this attribute
        availSchedule.put("Friday", arr[4].split(";"));
        availSchedule.put("Saturday", arr[5].split(";"));
        availSchedule.put("Sunday", arr[6].split(";"));
        availSchedule.put("Monday", arr[7].split(";"));
        availSchedule.put("Tuesday", arr[8].split(";"));
        availSchedule.put("Wednesday", arr[9].split(";"));
        availSchedule.put("Thursday", arr[10].split(";"));

        daysPerWeek = calcDPW();
        shiftsPerDay.put("Friday", calcSPD("Friday"));
        shiftsPerDay.put("Saturday", calcSPD("Saturday"));
        shiftsPerDay.put("Sunday", calcSPD("Sunday"));
        shiftsPerDay.put("Monday", calcSPD("Monday"));
        shiftsPerDay.put("Tuesday", calcSPD("Tuesday"));
        shiftsPerDay.put("Wednesday", calcSPD("Wednesday"));
        shiftsPerDay.put("Thursday", calcSPD("Thursday"));

        numShiftsAssigned = 0;
    }
    private int calcDPW(){
        String[] temp = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int counter = 0;
        for(String i : temp){
            if(availSchedule.get(i).length > 0) counter++;
        }
        return counter;
    }
    private Integer calcSPD(String s){
        return availSchedule.get(s).length;
    }
    //getName method to access name attribute
    public String getName(){return name;}
    //getPhoneNumber method to access phoneNumber attribute
    public String getPhoneNumber(){return phoneNumber;}
    public Integer getSPD(String s){return shiftsPerDay.get(s);}
}
