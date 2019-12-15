package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;

public class WeatherTest {
    private final String LINK_FOR_WEATHER_API = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=4297348650004b46b8d154658191012&q=Homyel&format=xml&date=2017-01-01&enddate=2018-01-01";
    private final String LINK_FOR_NRB_API = "http://www.nbrb.by/api/exrates/rates/840?parammode=1&ondate=";
    HashSet<String> dates;
    int count = 0;
    Date thusday;
    Date friday;
    DateFormat dateFormat;

    @Test
    public void Go() {


        Assert.assertTrue(dates.size() % count <= 2);
    }
}