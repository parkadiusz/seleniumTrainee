package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MenuPage;

import java.util.concurrent.TimeUnit;

import static helpers.Configuration.getConfiguration;
import static helpers.DriverConfig.initializeWebDriver;

public class TransfersTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = initializeWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(getConfiguration().getSiteURL());
    }

    @Test
    public void sendTransfersAndCheckIfAmountIsCorrectTest(){
        MenuPage menuPage = new MenuPage(driver);
        //TransfersPage transfersPage = menuPage.selectTransfersPage();
    }
}
