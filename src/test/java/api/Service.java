package api;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Service {
    XmlPath bodyXMLResponse;

    public XmlPath getDateFromWeatherService(String weatherApiLink) {
        Response weatherResponse = new Service().doGetResponseFromApi(weatherApiLink);
        bodyXMLResponse = weatherResponse.getBody().xmlPath();
        return bodyXMLResponse;
    }

    public HashSet<Date> filterDateFromWeatherResponse(XmlPath bodyXMLResponse) {
        Node node = bodyXMLResponse.getNode("data");
        List<Node> children = node.getNodes("weather");
        HashSet<Date> dates = new HashSet<>();
        for (Node weather : children) {
            List<Node> hours = weather.getNodes("hourly");
            for (Node hour : hours) {
                Double temp = Double.parseDouble(hour.getNode("tempC").value());
                Double precipMM = Double.parseDouble(hour.getNode("precipMM").value());
                if (temp > 0 && precipMM > 0) {
                    dates.add(getDate(weather.getNode("date").value()));
                }
            }
        }
        return dates;
    }

    public Date getDate(String dateAsString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response doGetResponseFromApi(String uri) {
        return RestAssured.get(uri);
    }

    public Date getNextBankWorkingDay(Date day, int count) {
        Calendar calendarDay = Calendar.getInstance();
        calendarDay.setTime(day);
        calendarDay.add(Calendar.DATE, count);
        Date nextDay = calendarDay.getTime();
        return nextDay;
    }

    public HashSet<Date> getThursdayRunningDates(String LINK_FOR_WEATHER_API) {
        return filterDateFromWeatherResponse(getDateFromWeatherService(LINK_FOR_WEATHER_API));
    }

    public int getOfficialRateChangeCount(String LINK_FOR_NRB_API, HashSet<Date> dates) {
        int count=0;
        for (Date date : dates) {
            NRBCurrency thousthCurrency = new Service().doGetResponseFromApi(LINK_FOR_NRB_API + getStringFromDate(date))
                    .as(NRBCurrency.class);
            Date nextWorkingDay = new Service().getNextBankWorkingDay(date, 1);
            NRBCurrency fridayCurency = new Service().doGetResponseFromApi(LINK_FOR_NRB_API + getStringFromDate(nextWorkingDay))
                    .as(NRBCurrency.class);

            if (thousthCurrency.OfficialRate < fridayCurency.OfficialRate) {
                count++;
            }
        }
            return count;
        }

        public String getStringFromDate (Date date){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date);
        }
    }