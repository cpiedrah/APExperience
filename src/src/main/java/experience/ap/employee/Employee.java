package experience.ap.employee;
import experience.ap.shift.Shift;

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
    private HashMap<String, Shift[]> availSchedule;
    //args-constructor so only full people can be created
    //incomplete Employees will disrupt the future code
    public Employee(String[] arr){
        name = arr[1] + arr[2];
        phoneNumber = arr[3];
        //need to create a way to read in an Excel Sheet and fill this attribute
        availSchedule.put("Friday", createShiftArray(arr[4].split(";")));
        availSchedule.put("Saturday", createShiftArray(arr[5].split(";")));
        availSchedule.put("Sunday", createShiftArray(arr[6].split(";")));
        availSchedule.put("Monday", createShiftArray(arr[7].split(";")));
        availSchedule.put("Tuesday", createShiftArray(arr[8].split(";")));
        availSchedule.put("Wednesday", createShiftArray(arr[9].split(";")));
        availSchedule.put("Thursday", createShiftArray(arr[10].split(";")));
    }
    //getName method to access name attribute
    public String getName(){return name;}
    //getPhoneNumber method to access phoneNumber attribute
    public String getPhoneNumber(){return phoneNumber;}
    public static Shift[] createShiftArray(String[] arr){
        Shift[] arrShift = new Shift[arr.length];
        for(int i = 0; i < arr.length; i++){
            arrShift[i] = new Shift(arr[i]);
        }
    }
}
