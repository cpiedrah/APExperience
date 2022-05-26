package experience.ap.shift;
import java.util.Calendar;

public class Shift {
    private final Calendar startTime;
    private final Calendar endTime;

    public Shift(Calendar sT, Calendar eT){
        startTime = sT;
        endTime = eT;
    }

    public Calendar getStartTime(){return startTime;}
    public Calendar getEndTime(){return endTime;}

}
