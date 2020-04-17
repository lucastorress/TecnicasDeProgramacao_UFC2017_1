package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDate {
    public static String dateToString(Date date) throws Exception {
        String day = date.toString().substring(8, 10);
        String month = date.toString().substring(5, 7);
        String year = date.toString().substring(0, 4);
        
        return day + "/" + month + "/" + year;
    }
    
    public static String dateToSQLString(Date date) throws Exception {
        String day = date.toString().substring(8, 10);
        String month = date.toString().substring(5, 7);
        String year = date.toString().substring(0, 4);
        
        return year + "-" + month + "-" + day;
    }
    
    public static Date stringToDate(String string) throws Exception {
        try {
            Date date =  new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(string).getTime());
            return date;
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
