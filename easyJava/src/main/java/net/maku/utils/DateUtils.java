package net.maku.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String YYYY_MM_DD="yyyy-MM-dd";
    public static final String YYYYMMDD="yyyy/MM/dd";
    public static final String _YYYYMMDD="yyyyMMdd";
    public static String format(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }
    public static Date parse(String date,String pattern){
        try{
            new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
