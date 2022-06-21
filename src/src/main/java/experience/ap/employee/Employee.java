package experience.ap.employee;
import experience.ap.days.Days;
import experience.ap.shift.Shift;

import java.util.ArrayList;
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
    private HashMap<Days, String[]> availSchedule;
    //assignedSchedule will be what is finally put out for the
    //employer to see, using the availSchedule as reference
    private HashMap<Days, ArrayList<Shift>> assignedSchedule;
    //args-constructor so only full people can be created
    //incomplete Employees will disrupt the future code
    public Employee(String[] arr){
        name = arr[1] + arr[2];
        phoneNumber = arr[3];
        //need to create a way to read in an Excel Sheet and fill this attribute
        availSchedule.put(Days.FRIDAY, arr[4].split(";"));
        availSchedule.put(Days.SATURDAY, arr[5].split(";"));
        availSchedule.put(Days.SUNDAY, arr[6].split(";"));
        availSchedule.put(Days.MONDAY, arr[7].split(";"));
        availSchedule.put(Days.TUESDAY, arr[8].split(";"));
        availSchedule.put(Days.WEDNESDAY, arr[9].split(";"));
        availSchedule.put(Days.THURSDAY, arr[10].split(";"));
    }
    //getName method to access name attribute
    public String getName(){return name;}
    //getPhoneNumber method to access phoneNumber attribute
    public String getPhoneNumber(){return phoneNumber;}
}
