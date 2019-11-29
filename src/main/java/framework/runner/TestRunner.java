package framework.runner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import framework.logger.Log;
import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;


public class TestRunner {
    public static void main(String[] args) {
    PropertyConfigurator.configure(TestRunner.getLog4jLink());
    parseCla(args);
    createTestSuite().run();

}
    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    String suiteName;



    private static void parseCla(String[] args) {
        Log.info("Parse command line args with JCommander");
        JCommander jCommander = new JCommander(Parameters.instance());
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            Log.error("Can't parse parameters");
            System.exit(1);
        }
        if (Parameters.instance().isHelp()) {
            jCommander.usage();
            System.exit(0);
        }
    }

    public static TestNG createTestSuite() {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(TestRunner.getTestSuiteLink());
        return testNG;
    }

    private static List<String> getTestSuiteLink() {
         ArrayList<String> linksList= new ArrayList<String>();
        linksList.add( String.format("./src/test/resources/%s.xml", (Parameters.instance().getSuite())));
       return linksList;
    }

    private static String getLog4jLink() {

        return String.format("./src/test/resources/%s.properties", (Parameters.instance().getLogPropertiesFile()));
    }
}