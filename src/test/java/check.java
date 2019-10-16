import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class check {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.youtube.com/watch?v=ijZ2aDoPPNk");
        Thread.sleep(1000);
        driver.quit();
    }
}
