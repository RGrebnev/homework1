import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    private static WebDriver driver;
    private static String browserType = System.getProperty("browser");
    private static Logger logger = LogManager.getLogger(WebDriverConfig.class);


    public static WebDriver getDriver() {
        if (driver == null) {
            if (browserType == null) browserType = "chrome";
            switch (browserType.toLowerCase()) {
                case "chrome":
                    initChrome();
                    break;
                case "firefox":
                    initFirefox();
                    break;
                default:
                    logger.warn("wrong arg browser=\"" + browserType + "\". Chrome driver will be set up");
                    initChrome();
            }
        }
        return driver;
    }

    private static void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private static void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
