package P3.recources;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helpers {
    public Date dateFromString(String date, String dateFormat) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
        java.util.Date newDate = null;
        try {
            newDate = sdf1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date newDateFromString = new Date(newDate.getTime());

        return newDateFromString;
    }
}
