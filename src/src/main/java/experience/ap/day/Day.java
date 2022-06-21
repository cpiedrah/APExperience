package experience.ap.day;
import experience.ap.employee.Employee;
import experience.ap.shift.Shift;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class Day {
    private String dayOfWeek;
    private ArrayList<Shift> shifts;
    private HashMap<String, ArrayList<Employee>> assignedEmployees;

    public Day(String dOW){
        dayOfWeek = dOW;
        shifts.add(new Shift("8-4:30"));
        shifts.add(new Shift("9-5:30"));
        shifts.add(new Shift("11-7:30"));
        shifts.add(new Shift("11:30-8"));
        shifts.add(new Shift("1-9:30"));
    }

}
