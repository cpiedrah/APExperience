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
}
