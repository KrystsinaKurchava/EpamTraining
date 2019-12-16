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
        parseCommandLineArguments(args);
        PropertyConfigurator.configure(TestRunner.getLog4jLink());
        createTestSuite().run();
    }

    private static void parseCommandLineArguments(String[] args) {
        JCommander jCommander = new JCommander(Parameters.instance());
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
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
        ArrayList<String> linksList = new ArrayList<String>();
        linksList.add(String.format("./%s/%s.xml", Parameters.instance().getResourcesAddress(), (Parameters.instance().getSuite())));
        return linksList;
    }

    private static String getLog4jLink() {
        return String.format("./%s/%s.properties", Parameters.instance().getResourcesAddress(), (Parameters.instance().getLogPropertiesFile()));
    }
}