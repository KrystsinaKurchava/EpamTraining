package api.holidayapi.product.service;

import api.holidayapi.product.models.Holiday;
import api.holidayapi.product.models.Holidays;
import api.utils.ApiUtils;
import api.utils.DateUtils;

import java.util.Date;

public class HolidayService {
    private final String HOLIDAY_API_URL = "https://date.nager.at/api/v1";
    private final String HOLIDAYS_FOR_COUNTRY_AND_YEAR_URL = HOLIDAY_API_URL + "/get/%s/%s";
    private final String BELARUS_CODE = "BY";

    public boolean isBelarusStateHoliday(Date date) {
        int year = DateUtils.getYear(date);
        String uri = String.format(HOLIDAYS_FOR_COUNTRY_AND_YEAR_URL, BELARUS_CODE, year);

        Holidays response = ApiUtils
                .doGetResponseFromApi(uri)
                .getBody()
                .as(Holidays.class);

        for (Holiday holiday : response) {
            if (DateUtils.isEqualWithoutTime(holiday.date, date))
                return true;
        }
        return false;
    }
}
