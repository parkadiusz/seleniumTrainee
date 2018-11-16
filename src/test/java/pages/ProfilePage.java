package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "update-name")
    WebElement profileName;

    @FindBy(id = "update-street")
    WebElement profileStreet;

    @FindBy(id = "update-city")
    WebElement profileCity;

    @FindBy(id = "update-postalcode")
    WebElement profilePostalcode;

    @FindBy(id = "update-email")
    WebElement profileEmail;

    @FindBy(id = "update-country")
    WebElement updateCountry;

    @FindBy(css = "label[for='update-gender-male']")
    WebElement updateGenderMale;

    @FindBy(css = "label[for='update-gender-female']")
    WebElement updateGenderFemale;

    @FindBy(css = "label[for='update-gender-dont']")
    WebElement updateGenderDont;

    @FindBy(css = "label[for='update-newsletter']")
    WebElement updateNewsletter;

    @FindBy(id = "update-newsletter")
    WebElement updateNewsletterState;

    @FindBy(id = "update-additional")
    WebElement updateAdditionalMessage;

    @FindBy(css = "input[value='Save']")
    WebElement sendButton;

    public enum GENDER_TYPE {
    MALE, FEMALE, DONTASK
    }
    public ProfilePage updateName(String newName){
        type(profileName,newName);
        return this;
    };

    public ProfilePage updateCity(String newCity){
        type(profileCity, newCity);
        return this;
    }

    public ProfilePage updateStreet( String newStreet){
        type(profileStreet, newStreet);
        return this;
    }

    public ProfilePage updatePostalCode(String newPostalCode){
        type(profilePostalcode, newPostalCode);
        return this;
    }

    public ProfilePage updateEmail(String newEmail){
        type(profileEmail, newEmail);
        return this;
    }

    public ProfilePage updateCountry( String selectedCountry){
        selectByVisibleText(updateCountry, selectedCountry);
        return this;
    }

    public ProfilePage selectGender(GENDER_TYPE gender_type){
       switch (gender_type){
           case MALE:
               click(updateGenderMale);
               return this;
           case FEMALE:
               click(updateGenderFemale);
               return this;
           case DONTASK:
               click(updateGenderDont);
               return this;
       }
       return this;
    }
}
