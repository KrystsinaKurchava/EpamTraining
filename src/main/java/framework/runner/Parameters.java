package framework.runner;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.remote.BrowserType;

public final class Parameters {
    public static Parameters instance;

    public String getSuite() {
        return suite;
    }

    @Parameter(names = {"--suite", "-s"},  description = "Suite")
    private String suite="yandex-all";

    @Parameter(names = {"--help"}, help = false, description = "Help")
    private boolean help;
    @Parameter(names = {"--browser", "-br"}, description = "Browser type",
            required = true)
    private String browserType=BrowserType.CHROME;
    @Parameter(names = {"--properties", "-prop"}, description = "Properties type")
    private String propertiesFile="qa";

    public String getLogPropertiesFile() {
        return logPropertiesFile;
    }

    @Parameter(names = {"--logProperties", "-Lprop"}, description = "Properties type")
    private String logPropertiesFile="log4j";

    private Parameters(){
    }
    public String getPropertiesFile() {
        return propertiesFile;
    }

    public static synchronized Parameters instance(){
        if(instance == null){
            instance = new Parameters();
        }
        return instance;
    }

    public boolean isHelp(){
        return help;
    }

    public String getBrowserType() {
        return browserType.toLowerCase();

    }
}