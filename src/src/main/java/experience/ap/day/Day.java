package experience.ap.day;
import experience.ap.employee.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class Day {
    private String dayOfWeek;
    //Key: String = Shift time
    //Value: ArrayList<Employee>
    private HashMap<String, ArrayList<Employee>> assignedEmployees;

    public Day(String dOW){
        dayOfWeek = dOW;
        assignedEmployees.put("8-4:30", new ArrayList<Employee>());
        assignedEmployees.put("9-5:30", new ArrayList<Employee>());
        assignedEmployees.put("11-7:30", new ArrayList<Employee>());
        assignedEmployees.put("11:30-8", new ArrayList<Employee>());
        assignedEmployees.put("1-9:30", new ArrayList<Employee>());
    }
    public String getDayOfWeek(){return dayOfWeek;}

    public HashMap<String, ArrayList<Employee>> getAssignedEmployees(){
        return assignedEmployees;
    }

}
