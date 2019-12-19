package api;

import api.holidayapi.product.service.HolidayService;
import api.nbrb.product.service.OfficialRateService;
import api.utils.DateUtils;
import api.worldweatheronline.product.service.WeatherService;
import framework.logger.Log;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashSet;

public class WeatherAndNRBService {
    private WeatherService weatherService = new WeatherService();
    private OfficialRateService officialRateService = new OfficialRateService();
    private HolidayService holidayService = new HolidayService();
    private final int CURRENT_DATE_STEP = 1;
    private final int NEXT_DATE_STEP = 1;
    private final String ARRAY_SEPARATOR = ",";

    public HashSet<Date> getThursdayRunningDates() {
        Log.info("Get raining Thursdays hashset");
        return weatherService.filterDateFromWeatherResponse(weatherService.getDateFromWeatherService());
    }

    /**
     * Get information about the change official rate on this day and the next.
     * If the day is holiday, roll to the working day
     * Return result of enumeration and comparison among themselves.
     */

    public int getOfficialRateChangesCount(HashSet<Date> dates) {
        Log.info("Get official rates for %s dates", StringUtils.join(dates.toArray(), ARRAY_SEPARATOR));
        int count = 0;
        for (Date date : dates) {
            date = getBankWorkingDay(date, CURRENT_DATE_STEP);
            Date nextWorkingDay = DateUtils.getDayWithOffset(date, NEXT_DATE_STEP);
            nextWorkingDay = getBankWorkingDay(nextWorkingDay, NEXT_DATE_STEP);
            double dateOfficialRate = officialRateService.getUsdOfficialRate(date);
            double nextWorkingDayOfficialRate = officialRateService.getUsdOfficialRate(nextWorkingDay);
            if (dateOfficialRate < nextWorkingDayOfficialRate) {
                count++;
            }
        }
        return count;
    }

    private Date getBankWorkingDay(Date date, int step) {
        Date workingDay = date;
        if (holidayService.isBelarusStateHoliday(workingDay) || DateUtils.isWeekend(date)) {
            workingDay = DateUtils.getDayWithOffset(workingDay, step);
        }
        return workingDay;
    }
}