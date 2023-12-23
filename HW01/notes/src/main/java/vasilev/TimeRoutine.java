package main.java.vasilev;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeRoutine {
    public static String getCurrentTime() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy k:mm:ss");

        return sdf.format(date);
    }
}
