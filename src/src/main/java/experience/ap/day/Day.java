package experience.ap.day;
import experience.ap.employee.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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


public class Day {
    private String dayOfWeek;
    //Key: String = Shift time
    //Value: ArrayList<Employee>
    private HashMap<String, ArrayList<Employee>> assignedEmployees;

    public Day(String dOW){
        dayOfWeek = dOW;
        assignedEmployees = new HashMap<String, ArrayList<Employee>>();
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
