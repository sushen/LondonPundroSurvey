package blog.video.biswas.londonpundrosurvey;

import android.text.format.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHandler {

    //Having System Date
    //-------------------------------------------
    public static String getSystemDate()
    {
        Date cal_date = Calendar.getInstance().getTime();
        String sys_date = new SimpleDateFormat("dd/MM/yyyy").format(cal_date);
        return sys_date;
    }

    //Having System Time
    //-------------------------------------------
    public static String getSystemTime()
    {
        Time TimeNow = new Time();
        TimeNow.setToNow();
        return TimeNow.hour+":"+TimeNow.minute;
    }


}
