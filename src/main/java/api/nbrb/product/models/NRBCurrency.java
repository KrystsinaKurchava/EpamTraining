package api.nbrb.product.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NRBCurrency {
    @JsonProperty("Cur_ID")
    public int id;
    @JsonProperty("Date")
    public String date;
    @JsonProperty("Cur_Abbreviation")
    public String abbreviation;
    @JsonProperty("Cur_Scale")
    public int scale;
    @JsonProperty("Cur_Name")
    public String name;
    @JsonProperty("Cur_OfficialRate")
    public Double officialRate;
}