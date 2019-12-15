package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NRBCurrency {
    @JsonProperty("Cur_ID")
    public int Id;
    @JsonProperty("Date")
    public String Date;
    @JsonProperty("Cur_Abbreviation")
    public String Abbreviation;
    @JsonProperty("Cur_Scale")
    public int Scale;
    @JsonProperty("Cur_Name")
    public String Name;
    @JsonProperty("Cur_OfficialRate")
    public Double OfficialRate;
}
