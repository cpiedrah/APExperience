package experience.ap.shift;
import java.util.Calendar;

public class Shift {
    //Every Shift has a designated start time (Ex. 8:30)
    private final Calendar startTime;
    //Every Shift has a designated end time after the start time
    private final Calendar endTime;
    //Only args-constructor because we want the shift to always
    //have a start and end time already designated
    public Shift(Calendar sT, Calendar eT){
        startTime = sT;
        endTime = eT;
    }
    //getStartTime method for later use
    public Calendar getStartTime(){return startTime;}
    //getEndTime method for later use
    public Calendar getEndTime(){return endTime;}

    //goals for this class: read in the available shift times
    //per day for a given worker and create a HashMap in
    //the employee class where the key - (String day)
    //corresponds to an arrayList of Shift objects/
}
