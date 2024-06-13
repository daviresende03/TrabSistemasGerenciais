package domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final Date stringToDate(String dateString){
        Date date = new Date();
        
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            return date;
        }
        return date;
    }
    
    public static final String dateToString(Date date){
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
}
