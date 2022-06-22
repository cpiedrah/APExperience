package experience.ap.schedule;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import experience.ap.employee.Employee;
import experience.ap.day.Day;
public class Schedule {
    private ArrayList<Day> assignedSchedule;
    public Schedule(){
        assignedSchedule = new ArrayList<Day>();
        assignedSchedule.add(new Day("Friday"));
        assignedSchedule.add(new Day("Saturday"));
        assignedSchedule.add(new Day("Sunday"));
        assignedSchedule.add(new Day("Monday"));
        assignedSchedule.add(new Day("Tuesday"));
        assignedSchedule.add(new Day("Wednesday"));
        assignedSchedule.add(new Day("Thursday"));
    }
    public ArrayList<Day> getAssignedSchedule(){return assignedSchedule;}
    public void setAssignedSchedule(ArrayList<Day> aS){this.assignedSchedule = aS;}

    /*
    assignedSchedule:
        Friday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
        Saturday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
        Sunday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
        Monday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
        Tuesday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
        Wednesday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
        Thursday:
            8-4:30: Emp1, Emp2
            9-:5:30: Emp1, Emp2
            11-:7:30: Emp1, Emp2
            11:30-8: Emp1, Emp2
            1-9:30: Emp1, Emp2
     */
}
