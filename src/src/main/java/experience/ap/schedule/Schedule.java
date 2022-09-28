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
import experience.ap.util.Constants;

    /*<Schedule Maker. Creates a schedule based on employee availability.>
    Copyright (C) <2022>  <Christian Piedrahita, Anoop Krishnadas>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
    */

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
    public String toString(){
        String stringToReturn = "";
        for(Day d: assignedSchedule){
            stringToReturn += d.getDayOfWeek() + ":\n";
            for(String shifts : Constants.SHIFTS){
                ArrayList<Employee> empsToPrint = d.getAssignedEmployees().get(shifts);
                stringToReturn += "\t" + shifts + ": " + empsToPrint.get(0).getName() + ", " + empsToPrint.get(1).getName() + "\n";
            }
        }
        return stringToReturn;
    }
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
