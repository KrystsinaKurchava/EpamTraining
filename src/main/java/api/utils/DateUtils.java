package api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date getDate(String dateAsString) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            return dateFormat.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDayWithOffset(Date date, int offset) {
        Calendar calendarDay = Calendar.getInstance();
        calendarDay.setTime(date);
        calendarDay.add(Calendar.DATE, offset);
        Date nextDay = calendarDay.getTime();
        return nextDay;
    }

    public static int getYear(Date date) {
        Calendar calendarDay = Calendar.getInstance();
        calendarDay.setTime(date);
        return calendarDay.get(Calendar.YEAR);
    }

    public static String getStringFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static boolean isEqualWithoutTime(Date equivalentDate, Date dateForComparing) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(equivalentDate).equals(dateFormat.format(dateForComparing));
    }

    public static boolean isWeekend(Date date) {
        Calendar calendarDay = Calendar.getInstance();
        calendarDay.setTime(date);
        DayOfWeek dayOfWeek = DayOfWeek.of(calendarDay.get(Calendar.DAY_OF_WEEK));
        return dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}