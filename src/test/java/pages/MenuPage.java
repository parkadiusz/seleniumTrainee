package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (linkText = "TRANSFER")
    WebElement transfer;

    @FindBy(linkText = "a[href=\"profile.html\"]")
    WebElement profile;

//    public TransfersPage selectTransfersPage(){
//        click(transfer);
//        return new TransfersPage(driver);
//    }

    public ProfilePage selectProfilePage(){
        profile.click();
        //click(profile);
        return new ProfilePage(driver);
    }
}
