package com.techcrunch.pages;

import com.techcrunch.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This class is base class for the other pages.
//I will put all common elements here for the other pages can get through OOP
public class BasePage {
    //this method (construction) is for re-introducing the web element to driver whenever we call it.
    // It helps avoid Stale Element Exception.
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //I am not using this element but put it here for being an example
    @FindBy(xpath = "//a[@data-ga-event-label='Crypto']")
    public WebElement menuItem_Crypto;

    //This element is for close button for ribbon bottom of the page
    @FindBy(xpath = "//button[@class='pn-ribbon__close']")
    private WebElement ribbonCloseButton;

    //This element is iframe which the ribbon is inside
    @FindBy(xpath = "//div[@class='piano-ribbon-container']//iframe")
    private WebElement ribbonIframe;

    //This method change driver focus to iframe and close ribbon and change focus to main frame.
    public void ribbonCloseMethod() {
        Driver.getDriver().switchTo().frame(ribbonIframe);
        ribbonCloseButton.click();
        Driver.getDriver().switchTo().parentFrame();
    }

}
