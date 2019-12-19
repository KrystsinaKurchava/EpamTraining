package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashSet;

public class WeatherTest {
    private final int TEST_CRITERIA = 2;

    @Test(description = "Check hypothesis about dependency about Thursday rain and rating increase")
    public void checkThursdayTheory() {
        WeatherAndNRBService weatherAndNRBService = new WeatherAndNRBService();
        HashSet<Date> dates = weatherAndNRBService.getThursdayRunningDates();
        int count = weatherAndNRBService.getOfficialRateChangesCount(dates);
        Assert.assertTrue(dates.size() % count <= TEST_CRITERIA, "Dependency is not proved");
    }
}