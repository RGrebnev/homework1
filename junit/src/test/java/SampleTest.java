import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SampleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    OwnerConfig cfg = ConfigFactory.create(OwnerConfig.class);

    @Before
    public void setUp() {
        driver = WebDriverConfig.getDriver();
        logger.info("Driver is up");
    }
    @Test
    public void openPage() {
        driver.get(cfg.url());
        logger.info("Otus page open");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}