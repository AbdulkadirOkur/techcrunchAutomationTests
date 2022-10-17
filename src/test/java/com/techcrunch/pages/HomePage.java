package com.techcrunch.pages;

import com.techcrunch.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class HomePage extends BasePage {

    //This method is which I can get the latest news as a list of web elements by FindElements method
    public List<WebElement> getLatestNews() {
        return Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//article"));
    }

    //This method asserts each the latest news has an author
    public void assertThatAllLatestNewsHasAuthor() {
        //I can not be sure how many new's article on homepage (usually 20) so I am getting number from this code
        int newsNumber = getLatestNews().size();
        //checking every one of news article through its child element and getting author elements (Some news has more than 1 author)
        for (int i = 1; i <= newsNumber; i++) {
            List<WebElement> newsAuthors = Driver.getDriver().findElements(By.xpath("(//div[@class='river river--homepage ']//article)[" + i + "]//a[contains(@aria-label,'Posts by')]"));
            boolean isAuthorNumGreaterThanZero = newsAuthors.size() > 0;
            Assert.assertTrue(i + " number of news do not have author", isAuthorNumGreaterThanZero);
        }
    }
    //This method asserts each the latest news has an image
    public void assertThatAllLatestNewsHasImage() {
        //I can not be sure how many new's article on homepage ( usually 20) so I am getting number from this code
        int newsNumber = getLatestNews().size();
        //checking every one of news article through its child element and getting Image elements
        for (int i = 1; i <= newsNumber; i++) {
            List<WebElement> newsImages = Driver.getDriver().findElements(By.xpath("(//div[@class='river river--homepage ']//article)[" + i + "]//img"));
            boolean isImageNumGreaterThanZero = newsImages.size() > 0;
            Assert.assertTrue(i + " number of news do not have Image", isImageNumGreaterThanZero);
        }
    }
    //this method is for geting one of the latest news randomly
    public WebElement getARandomLatestNewsElement(){
        return getLatestNews().get((int)(Math.random()*(getLatestNews().size()+1)));
    }

}
