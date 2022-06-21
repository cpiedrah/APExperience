package experience.ap.shift;
import experience.ap.employee.Employee;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Shift {

    private ArrayList<Employee> employees;
    //Every Shift has a designated start time (Ex. 8:30)
    private final GregorianCalendar startTime;
    //Every Shift has a designated end time after the start time
    private final GregorianCalendar endTime;
    //Only args-constructor because we want the shift to always
    //have a start and end time already designated
    public Shift(GregorianCalendar sT, GregorianCalendar eT){
        startTime = sT;
        endTime = eT;
    }
    //getStartTime method for later use
    public GregorianCalendar getStartTime(){return startTime;}
    //getEndTime method for later use
    public GregorianCalendar getEndTime(){return endTime;}
    public static Shift toShift(String s){
        s = s.replaceAll("\\s", "");

        if(s.equals("8-4:30")){
            return new Shift(new GregorianCalendar(), new GregorianCalendar());
        }
        else if(s.equals("9-5:30")){
            return new Shift(new GregorianCalendar(), new GregorianCalendar());
        }
        else if(s.equals("11-7:30")){
            return new Shift(new GregorianCalendar(), new GregorianCalendar());
        }
        else if(s.equals("11:30-8")){
            return new Shift(new GregorianCalendar(), new GregorianCalendar());
        }
        else if(s.equals("1-9:30")){
            return new Shift(new GregorianCalendar(), new GregorianCalendar());
        }
    }
    public static Shift[] createShiftArray(String[] arr){
        Shift[] arrShift = new Shift[arr.length];
        for(int i = 0; i < arr.length; i++){
            arrShift[i] = toShift(arr[i]);
        }
    }

    //goals for this class: read in the available shift times
    //per day for a given worker and create a HashMap in
    //the employee class where the key - (String day)
    //corresponds to an arrayList of Shift objects/
}
