package experience.ap.scheduler;

import experience.ap.day.Day;
import experience.ap.employee.Employee;
import experience.ap.schedule.Schedule;
import experience.ap.util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//C:\Users\piedrahitaclan\Downloads\Schedule Form Responses - Form Responses 1.csv

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

public class Scheduler {
    private ArrayList<Employee> roster;

    private ArrayList<String> unscheduledDays;

    private HashMap<String, ArrayList<String>> unscheduledShifts;
    /*
    Key is day of the week. Value is array list Employees
     */
    private HashMap<String, ArrayList<Employee>> dailyRoster;

    public Scheduler(){
        roster = new ArrayList<Employee>();
        unscheduledDays = new ArrayList<>();
        unscheduledShifts = new HashMap<>();
        for (String day: Constants.DAYS) {
            unscheduledDays.add(day);
        }
        dailyRoster = new HashMap<String, ArrayList<Employee>>();

        for (String day: Constants.DAYS) {
            unscheduledShifts.put(day,new ArrayList<String>(Constants.SHIFTS));
        }

    }
    public static void main(String[] args){

        Scheduler scheduler = new Scheduler();

        scheduler.setRoster(convertCSVToSchedule());

        scheduler.fillDailyRoster();

        Schedule schedule = new Schedule();

        ArrayList<Day> tempAssignedSchedule = schedule.getAssignedSchedule();
        while(scheduler.getUnscheduledDays().size() > 0) {
            String dayToFill = scheduler.calcLeastAvailDay();
            while (scheduler.getUnscheduledShifts().get(dayToFill).size() > 0) {
                ArrayList<Employee> assignedEmployees = new ArrayList<Employee>();
                String shiftToFill = scheduler.findLowestShiftCoverage(dayToFill);
                scheduler.getUnscheduledShifts().get(dayToFill).remove(shiftToFill);

                Employee emp1 = scheduler.findLeastAvailEmployee(dayToFill, shiftToFill);
                //using array list of employees as while loop counter AND
                //functionally to not process that employee again
                scheduler.getDailyRoster().get(dayToFill).remove(emp1);
                emp1.incrementNumShiftsAssigned();
                assignedEmployees.add(emp1);

                if(emp1.getNumShiftsAssigned() >= 5){
                    for(String day : Constants.DAYS){
                        scheduler.getDailyRoster().get(day).remove(emp1);
                    }
                }

                Employee emp2 = scheduler.findLeastAvailEmployee(dayToFill, shiftToFill);
                //using array list of employees as while loop counter AND
                //functionally to not process that employee again
                scheduler.getDailyRoster().get(dayToFill).remove(emp2);
                emp2.incrementNumShiftsAssigned();
                assignedEmployees.add(emp2);

                if(emp2.getNumShiftsAssigned() >= 5){
                    for(String day : Constants.DAYS){
                        scheduler.getDailyRoster().get(day).remove(emp2);
                    }
                }

                for (Day d : tempAssignedSchedule) {
                    if (d.getDayOfWeek().equals(dayToFill)) {
                        d.getAssignedEmployees().put(shiftToFill, assignedEmployees);
                    }
                }
            }
            scheduler.getUnscheduledDays().remove(dayToFill);
        }
        schedule.setAssignedSchedule(tempAssignedSchedule);
        System.out.println(schedule);

        /*
        for(Employee e : scheduler.roster){
            System.out.println("My name is " + e.getName() + " and I was assigned: " + e.getNumShiftsAssigned());
        }
         */
    }

    public void setRoster(ArrayList<Employee> tempRoster){
        this.roster.addAll(tempRoster);
    }
    public HashMap<String, ArrayList<String>> getUnscheduledShifts(){return unscheduledShifts;}
    public ArrayList<Employee> getRoster(){
        return this.roster;
    }

    public ArrayList<String> getUnscheduledDays(){
        return this.unscheduledDays;
    }

    private static String selectFile(){
        System.out.println("Enter CSV file path:");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        return userInput;
    }
    private static ArrayList<Employee> convertCSVToSchedule(){
        /*String path = "C:\Users\dpiedrah\OneDrive - Wiley\Desktop\Anoop_APE\SampleTextFile.csv";*/
        String path = selectFile();
        String line = "";
        try{
            ArrayList<Employee> tempRoster = new ArrayList<Employee>();
            BufferedReader bR = new BufferedReader(new FileReader(path));
            line = bR.readLine();
            while((line = bR.readLine()) != null){
                String[] arr = line.split(",");
                tempRoster.add(new Employee(arr));
            }
            return tempRoster;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return new ArrayList<Employee>();
        }
        catch(IOException e){
            e.printStackTrace();
            return new ArrayList<Employee>();
        }
    }

    public void fillDailyRoster(){
        String[] listOfDays = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        for(int i = 0; i < listOfDays.length; i++){

            ArrayList<Employee> availEmpsForDay = new ArrayList<Employee>();

            for(int j = 0; j < roster.size(); j++){

                if (roster.get(j).getShiftsPerDay(listOfDays[i]) > 0){
                    availEmpsForDay.add(roster.get(j));
                }
            }

            dailyRoster.put(listOfDays[i], availEmpsForDay);
        }
    }

    private String calcLeastAvailDay(){
        if(unscheduledDays.size() > 0){
            String lowestDay = unscheduledDays.get(0);
            int leastEmpCount = dailyRoster.get(lowestDay).size();
            for (int i = 1; i < unscheduledDays.size(); i++) {
                if (dailyRoster.get(lowestDay).size() < leastEmpCount) {
                    lowestDay = unscheduledDays.get(i);
                    leastEmpCount = dailyRoster.get(unscheduledDays.get(i)).size();
                }
            }
            return lowestDay;
        }
        return "";
    }

    private String findLowestShiftCoverage(String lowestDay){
        ArrayList<Employee> lowestDayEmployees = dailyRoster.get(lowestDay);
        String lowestShift = "";
        int lowestShiftEmpCount = Integer.MAX_VALUE;
        ArrayList<String> shiftList = unscheduledShifts.get(lowestDay);
        for(int i = 0; i < shiftList.size(); i++) {
            int currentShiftEmpCounter = 0;
            for (int j = 0; j < lowestDayEmployees.size(); j++) {
                String[] dayShifts = lowestDayEmployees.get(j).getDayAvailSchedule(lowestDay);
                boolean hasShift = false;
                for(String s : dayShifts){
                    //sL means a ShiftList item
                    String sL = shiftList.get(i);
                    if(s.equals(sL)){
                        hasShift = true;
                    }
                }
                if(hasShift) currentShiftEmpCounter++;
            }
            if(currentShiftEmpCounter < lowestShiftEmpCount){
                lowestShiftEmpCount = currentShiftEmpCounter;
                lowestShift = shiftList.get(i);
            }
        }
        return lowestShift;
    }

    public Employee findLeastAvailEmployee(String lowestDay, String lowestShift){
        ArrayList<Employee> availEmployeesForShift = new ArrayList<Employee>();
        ArrayList<Employee> lowestDayEmployees = dailyRoster.get(lowestDay);
        for(int i = 0; i <lowestDayEmployees.size(); i++){
            String[] dayShifts = lowestDayEmployees.get(i).getDayAvailSchedule(lowestDay);
            for(String s : dayShifts){
                if(s.equals(lowestShift)){
                    availEmployeesForShift.add(lowestDayEmployees.get(i));
                }
            }
        }
        int lowestDaysPerWeekScore = 8;
        for(Employee e: availEmployeesForShift){
            if(e.getDaysPerWeek() < lowestDaysPerWeekScore && e.getDaysPerWeek() > 0){
                lowestDaysPerWeekScore = e.getDaysPerWeek();
            }
        }
        ArrayList<Employee> lowestDaysPerWeekEmployees = new ArrayList<Employee>();
        for(Employee e: availEmployeesForShift){
            if(e.getDaysPerWeek() == lowestDaysPerWeekScore){
                lowestDaysPerWeekEmployees.add(e);
            }
        }
        if(lowestDaysPerWeekEmployees.size() == 1){
            return lowestDaysPerWeekEmployees.get(0);
        }
        int lowestShiftsPerDayScore = 6;
        for(Employee e: availEmployeesForShift){
            if(e.getShiftsPerDay(lowestDay) < lowestShiftsPerDayScore && e.getShiftsPerDay(lowestDay) > 0){
                lowestShiftsPerDayScore = e.getShiftsPerDay(lowestDay);
            }
        }
        ArrayList<Employee> lowestShiftsPerDayEmployees = new ArrayList<Employee>();
        for(Employee e: availEmployeesForShift){
            if(e.getShiftsPerDay(lowestDay) == lowestShiftsPerDayScore){
                lowestShiftsPerDayEmployees.add(e);
            }
        }
        if(lowestShiftsPerDayEmployees.size() == 1){
            return lowestShiftsPerDayEmployees.get(0);
        }
        if(lowestDaysPerWeekEmployees.size() > 1 && lowestShiftsPerDayEmployees.size() > 1){
            for(Employee e1: lowestDaysPerWeekEmployees){
                for(Employee e2: lowestShiftsPerDayEmployees) {
                    if (e1.equals(e2)) {
                        return e1;
                    }
                }
            }
            int randEmployee = (int)(Math.random() * lowestDaysPerWeekEmployees.size());
            return lowestDaysPerWeekEmployees.get(randEmployee);
        }
        if(lowestDaysPerWeekEmployees.size() < 1 && lowestShiftsPerDayEmployees.size()> 1){
            int randEmployee = (int)(Math.random() * lowestShiftsPerDayEmployees.size());
            return lowestShiftsPerDayEmployees.get(randEmployee);
        }
        if(lowestDaysPerWeekEmployees.size() > 1 && lowestShiftsPerDayEmployees.size() < 1){
            int randEmployee = (int)(Math.random() * lowestDaysPerWeekEmployees.size());
            return lowestDaysPerWeekEmployees.get(randEmployee);
        }
        String [] fillerEmployeeAttributes = {"","filler", "Employee", "", "", "", "", "", "", "", ""} ;
        Employee fillerEmployee = new Employee(fillerEmployeeAttributes);
        return fillerEmployee;

    }
    public HashMap<String, ArrayList<Employee>> getDailyRoster(){return this.dailyRoster;}

}
