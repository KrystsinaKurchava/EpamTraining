package api.worldweatheronline.product.service;

import api.utils.ApiUtils;
import api.utils.DateUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class WeatherService {
    private static final String LINK_FOR_WEATHER_API = "http://api.worldweatheronline.com/premium/v1/";
    private static final String LINK_FOR_WEATHER_FOR_DATES = LINK_FOR_WEATHER_API + "past-weather.ashx?key=4297348650004b46b8d154658191012&q=Homyel&format=xml&date=2017-01-01&enddate=2018-01-01";
    private final String ROOT_NODE_NAME = "data";
    private final String WEATHER_NODE_NAME = "weather";
    private final String HOURS_NODE_NAME = "hourly";
    private final String TEMPERATURE_NODE_NAME = "tempC";
    private final String PRECIPITATE_NODE_NAME = "precipMM";
    private final String DATE_NODE_NAME = "date";
    private final int BORDER_CRITERIA = 0;

    public XmlPath getDateFromWeatherService() {
        Response weatherResponse = ApiUtils.doGetResponseFromApi(LINK_FOR_WEATHER_FOR_DATES);
        return weatherResponse.getBody().xmlPath();
    }

    public HashSet<Date> filterDateFromWeatherResponse(XmlPath bodyXMLResponse) {
        Node node = bodyXMLResponse.getNode(ROOT_NODE_NAME);
        List<Node> children = node.getNodes(WEATHER_NODE_NAME);
        HashSet<Date> dates = new HashSet<>();
        for (Node weather : children) {
            List<Node> hours = weather.getNodes(HOURS_NODE_NAME);
            for (Node hour : hours) {
                double temperature = Double.parseDouble(hour.getNode(TEMPERATURE_NODE_NAME).value());
                double precipitate = Double.parseDouble(hour.getNode(PRECIPITATE_NODE_NAME).value());
                if (temperature > BORDER_CRITERIA && precipitate > BORDER_CRITERIA) {
                    dates.add(DateUtils.getDate(weather.getNode(DATE_NODE_NAME).value()));
                }
            }
        }
        return dates;
    }
}