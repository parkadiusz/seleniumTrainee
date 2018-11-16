package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static helpers.Configuration.getConfiguration;
import static helpers.DriverConfig.initializeWebDriver;

public class testTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
    }
    @Test
    public void Test(){
        System.out.println("hello world");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
