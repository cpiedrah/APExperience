package experience.ap.employee;
import experience.ap.shift.Shift;
import java.util.ArrayList;
import java.util.HashMap;
@SuppressWarnings("FieldCanBeLocal")

public class Employee {
    //name  will be the way to refer to the employee
    //on the Excel file at the end
    private final String name;
    //phone number is for the convenience of the boss
    //for the end result of the project
    private final String phoneNumber;
    //availSchedule is when the employee is available to work
    //This takes the key (dayOfWeek - String) and returns an
    //arrayList of Shift objects according to when they are free
    private final HashMap<String, ArrayList<Shift>> availSchedule;
    //assignedSchedule will be what is finally put out for the
    //employer to see, using the availSchedule as reference
    private HashMap<String, ArrayList<Shift>> assignedSchedule;
    //I think your dad said we don't need a no-args
    //constructor for the Employee class, so I
    //commented it out. If we need it just
    //uncomment it by removing the "/**/"
    //from lines 25 and 30
    /*
    public Employee(){
        name = "";
        phoneNumber="";
    }
    */
    //args-constructor so only full people can be created
    //incomplete Employees will disrupt the future code
    public Employee(String n, String pN){
        name = n;
        phoneNumber = pN;
        //need to create a way to read in an Excel Sheet and fill this attribute
        availSchedule = null;
    }
    //getName method to access name attribute
    public String getName(){return name;}
    //getPhoneNumber method to access phoneNumber attribute
    public String getPhoneNumber(){return phoneNumber;}
}
