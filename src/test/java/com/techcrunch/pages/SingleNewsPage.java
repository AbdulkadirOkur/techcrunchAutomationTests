package com.techcrunch.pages;

import com.techcrunch.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SingleNewsPage extends BasePage {

    //this element is current news title
    @FindBy(xpath = "//h1[@class='article__title']")
    public WebElement currentNewsTitle;

    //this list contains all the links inside the news content
    public List<WebElement> getTheLinksInsideNewsContent() {
        return Driver.getDriver().findElements(By.xpath("//div[@class='article-content']/p/a"));
    }


}
