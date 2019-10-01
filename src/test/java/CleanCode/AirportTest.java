package CleanCode;

import CleanCode.Planes.ExperimentalPlane;
import CleanCode.models.ClassificationLevel;
import CleanCode.models.MilitaryType;
import CleanCode.Planes.MilitaryPlane;
import CleanCode.Planes.PassengerPlane;
import CleanCode.Planes.Plane;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET)
    );

    @Test
    public void getTransportMilitaryPlanesTest() {
        Airport airport = new Airport(planes);
        Assert.assertEquals(airport.getTransportMilitaryPlanes().size(), 1);
    }

    @Test
    public void getPassengerPlaneWithMaxCapacityTest() {
        Airport airport = new Airport(planes);
        Assert.assertTrue(airport.getPassengerPlaneWithMaxPassengersCapacity().equals(new PassengerPlane("Boeing-747", 980, 16100, 70500, 242)));
    }

    @Test
    public void sortByMaxLoadCapacityTest() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        Assert.assertEquals(airport.getPlanes().get(0).getMinLoadCapacity(), 500);
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanesTest() {
        Airport airport = new Airport(planes);
        Assert.assertTrue(airport.getBomberMilitaryPlanes().size() > 1);
    }

    @Test
    public void getExperimentalPlanesTest(){
        Airport airport = new Airport(planes);
        Assert.assertEquals(airport.getExperimentalPlanes().size(), 2);
    }
}
