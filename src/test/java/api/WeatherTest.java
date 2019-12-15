package api;

import framework.logger.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashSet;

public class WeatherTest {
    @Test(description = "Check hypothesis about dependency about Thursday rain and rating increase")
    public void CheckThursdayTheory() {
        Service service = new Service();
        HashSet<Date> dates = service.getThursdayRunningDates();
        int count = service.getOfficialRateChangesCount(dates);
        Assert.assertTrue(dates.size() % count <= 2, "Dependency is not proved");
    }
}