package framework.runner;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.remote.BrowserType;

public final class Parameters {
    public static Parameters instance;

    @Parameter(names = {"--suite", "-s"}, description = "Suite")
    private String suite = "smoke-test";
    
    @Parameter(names = {"--help"}, help = false, description = "Help")
    private boolean help;

    @Parameter(names = {"--browser", "-br"}, description = "Browser type",
            required = true)
    private String browserType = BrowserType.CHROME;

    @Parameter(names = {"--properties", "-prop"}, description = "Properties type")
    private String propertiesFile = "qa";

    @Parameter(names = {"--logProperties", "-Lprop"}, description = "Properties type")
    private String logPropertiesFile = "log4j";

    @Parameter(names = {"--resourcesAddress", "-r"}, description = "Resources address")
    private String resourcesAddress = "src\\test\\resources";

    @Parameter(names = {"--outputAddress", "-o"}, description = "Output data address")
    private String outputAddress = "target";

    @Parameter(names = {"--gridHost","-grHst"},  description = "Grid host address")
    private String gridHost = "localhost";

    @Parameter(names = {"--port", "-pr"}, description = "Port number")
    private String gridPortNumber ="5444";

    private Parameters() {
    }

    public static synchronized Parameters instance() {
        if (instance == null) {
            instance = new Parameters();
        }
        return instance;
    }

    public String getPropertiesFile() {
        return propertiesFile;
    }

    public String getSuite() {
        return suite;
    }

    public String getLogPropertiesFile() {
        return logPropertiesFile;
    }

    public String getResourcesAddress() {
        return resourcesAddress;
    }

    public String getOutputAddress() {
        return outputAddress;
    }

    public boolean isHelp() {
        return help;
    }

    public String getBrowserType() {
        return browserType.toLowerCase();
    }

    public String getGridHost() {
        return gridHost;
    }

    public String getGridPortNumber() {
        return gridPortNumber;
    }
}