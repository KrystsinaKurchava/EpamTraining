package api.holidayapi.product.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Holiday {
    @JsonProperty("date")
    public Date date;
    @JsonProperty("localName")
    public String localName;
    @JsonProperty("name")
    public String name;
    @JsonProperty("countryCode")
    public String countryCode;
    @JsonProperty("fixed")
    public boolean fixed;
    @JsonProperty("global")
    public boolean global;
    @JsonProperty("counties")
    public String counties;
    @JsonProperty("launchYear")
    public String launchYear;
    @JsonProperty("type")
    public String type;
}