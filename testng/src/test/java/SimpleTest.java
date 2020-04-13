import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SimpleTest.class);

    @BeforeTest
    public void setUp() {
        driver = WebDriverConfig.getDriver();
        logger.info("Driver is up");
    }
    @Test
    public void openPage() {
        driver.get("https://otus.ru/");
        logger.info("Otus page open");
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
