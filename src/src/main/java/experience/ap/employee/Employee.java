package experience.ap.employee;

import java.util.HashMap;
@SuppressWarnings("FieldCanBeLocal")

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
        availSchedule = new HashMap<String, String[]>();
        availSchedule.put("Friday", arr[4].replace('"',' ').trim().split(";"));
        availSchedule.put("Saturday", arr[5].replace('"',' ').trim().split(";"));
        availSchedule.put("Sunday", arr[6].replace('"',' ').trim().split(";"));
        availSchedule.put("Monday", arr[7].replace('"',' ').trim().split(";"));
        availSchedule.put("Tuesday", arr[8].replace('"',' ').trim().split(";"));
        availSchedule.put("Wednesday", arr[9].replace('"',' ').trim().split(";"));
        availSchedule.put("Thursday", arr[10].replace('"',' ').trim().split(";"));

        daysPerWeek = calcDaysPerWeek();
        shiftsPerDay = new HashMap<String, Integer>();
        shiftsPerDay.put("Friday", calcShiftsPerDay("Friday"));
        shiftsPerDay.put("Saturday", calcShiftsPerDay("Saturday"));
        shiftsPerDay.put("Sunday", calcShiftsPerDay("Sunday"));
        shiftsPerDay.put("Monday", calcShiftsPerDay("Monday"));
        shiftsPerDay.put("Tuesday", calcShiftsPerDay("Tuesday"));
        shiftsPerDay.put("Wednesday", calcShiftsPerDay("Wednesday"));
        shiftsPerDay.put("Thursday", calcShiftsPerDay("Thursday"));

        numShiftsAssigned = 0;
    }
    private int calcDaysPerWeek(){
        String[] temp = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int counter = 0;
        for(String i : temp){
            if(availSchedule.get(i).length > 0) counter++;
        }
        return counter;
    }
    private Integer calcShiftsPerDay(String s){
        return availSchedule.get(s).length;
    }
    //getName method to access name attribute
    public String getName(){return name;}
    //getPhoneNumber method to access phoneNumber attribute
    public String getPhoneNumber(){return phoneNumber;}
    public Integer getShiftsPerDay(String s){return shiftsPerDay.get(s);}

    public Integer getDaysPerWeek(){
        return daysPerWeek;
    }
    public String[] getDayAvailSchedule(String key){
        return availSchedule.get(key);
    }
    public void incrementNumShiftsAssigned(){numShiftsAssigned++;}
    public int getNumShiftsAssigned(){return numShiftsAssigned;}
}
