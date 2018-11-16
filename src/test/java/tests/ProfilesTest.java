package tests;

import TestData.ProfilesTestData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.ProfilePage;

import static helpers.Configuration.getConfiguration;
import static helpers.DriverConfig.initializeWebDriver;

public class ProfilesTest implements ProfilesTestData {
    private WebDriver driver;

    @BeforeClass
    public void SetUp(){
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
    }

    @Test
    public void updateUserProfileDataAndCheckItIsCorrectTest(){
        MenuPage menuPage = new MenuPage(driver);
        ProfilePage profilePage = menuPage.selectProfilePage()
                .updateName(NEW_NAME)
                .updateStreet(NEW_STREET)
                .updateCity(NEW_CITY)
                .updatePostalCode(NEW_POSTCODE)
                .updateEmail(NEW_EMAIL)
                .updateCountry(NEW_COUNTRY)
                .selectGender(ProfilePage.GENDER_TYPE.FEMALE);
    }
}
