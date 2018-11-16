package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasePage {
    protected Actions action;
    protected WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.action = new Actions(driver);
    }


    public void click(WebElement element){
        try{
            waitForElementToBeVisible(element).click();
        } catch (StaleElementReferenceException sere){
            waitForElementToBeVisible(element).click();
        }
    }

    public void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void selectByVisibleText(WebElement element, String text) {
        Select countryDropdown = new Select(element);
        countryDropdown.selectByVisibleText(text);
    }

    public void moveToElementAndClick(WebElement elementToBeClicked){
        action.moveToElement(elementToBeClicked).perform();
        click(elementToBeClicked);
    }


    public WebElement waitForElementToBeVisible(WebElement element){
        new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(10,TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
                //.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
