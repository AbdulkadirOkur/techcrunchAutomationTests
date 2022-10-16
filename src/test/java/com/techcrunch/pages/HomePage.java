package com.techcrunch.pages;

import com.techcrunch.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public List<WebElement> getLatestNews() {
        return Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//article"));
    }


    public void assertThatAllLatestNewsHasAuthor() {
        //I can not be sure how many new's article on homepage ( usually 20) so I am getting number from this code
        int newsNumber = Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//article")).size();
        //checking every one of news article through its child element and getting author elements (Some news has more than 1 author)
        for (int i = 1; i <= newsNumber; i++) {
            List<WebElement> newsAuthors = Driver.getDriver().findElements(By.xpath("(//div[@class='river river--homepage ']//article)[" + i + "]//a[contains(@aria-label,'Posts by')]"));
            boolean isAuthorNumGreaterThanZero = newsAuthors.size() > 0;
            Assert.assertTrue(i + " number of news do not have author", isAuthorNumGreaterThanZero);
        }
    }

    public void assertThatAllLatestNewsHasImage() {
        //I can not be sure how many new's article on homepage ( usually 20) so I am getting number from this code
        int newsNumber = Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//article")).size();
        //checking every one of news article through its child element and getting Image elements
        for (int i = 1; i <= newsNumber; i++) {
            List<WebElement> newsImages = Driver.getDriver().findElements(By.xpath("(//div[@class='river river--homepage ']//article)[" + i + "]//img"));
            boolean isImageNumGreaterThanZero = newsImages.size() > 0;
            Assert.assertTrue(i + " number of news do not have Image", isImageNumGreaterThanZero);
        }
    }


}
