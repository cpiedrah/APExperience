package experience.ap.day;
import experience.ap.shift.Shift;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Day {
    private String dayOfWeek;
    private ArrayList<Shift> shifts;

    public Day(String dOW){
        dayOfWeek = dOW;
        shifts.add(Shift.toShift("8-4:30"));
        shifts.add(Shift.toShift("9-5:30"));
        shifts.add(Shift.toShift("11-7:30"));
        shifts.add(Shift.toShift("11:30-8"));
        shifts.add(Shift.toShift("1-9:30"));
    }

}
