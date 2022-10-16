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
    public BasePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //I am not using this element but put it here for being an example
    @FindBy(xpath = "//a[@data-ga-event-label='Crypto']")
    public WebElement menuItem_Crypto;
}
