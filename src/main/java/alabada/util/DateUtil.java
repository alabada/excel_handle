package alabada.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String dateToString(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
}
