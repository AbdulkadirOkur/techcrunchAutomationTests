package com.techcrunch.stepDefinitions;

import com.techcrunch.pages.HomePage;
import com.techcrunch.pages.SingleNewsPage;
import com.techcrunch.utils.BrowserUtils;
import com.techcrunch.utils.ConfigurationReader;
import com.techcrunch.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LatestNewsStepDef {
    HomePage homePage = new HomePage();
    SingleNewsPage singleNewsPage = new SingleNewsPage();

    @Given("Navigate to home page")
    public void navigateToHomePage() {
        //We are using configuration.properties files to avoid hardcoding and put some important data here
        //We can easily chance some data inside configuration.properties instead of actual code.(for ex: environment , browser)
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        homePage.ribbonCloseMethod();
    }

    @Then("check each news and verify that each news has an author")
    public void checkEachNewsAndVerifyThatEachNewsHasAnAuthor() {
        homePage.assertThatAllLatestNewsHasAuthor();
    }

    @Then("check each news and verify that each news has an Image")
    public void checkEachNewsAndVerifyThatEachNewsHasAnImage() {
        homePage.assertThatAllLatestNewsHasImage();
    }

    @Then("Click one of news from The Latest News")
    public void clickOneOfNewsFromTheLatestNews() {
        homePage.getARandomLatestNewsElement().click();
    }

    @Then("browser title should contain news title")
    public void browserTitleShouldContainNewsTitle() {
        String browserTitle = Driver.getDriver().getTitle();
        String newsTitle = singleNewsPage.currentNewsTitle.getText();
        Assert.assertTrue(browserTitle.contains(newsTitle));

    }

    @Then("links within the news content should be valid links")
    public void linksWithinTheNewsContentShouldBeValidLinks() {
        List<WebElement> theLinksInsideNewsContent = singleNewsPage.getTheLinksInsideNewsContent();
        BrowserUtils.assertTheLinksInsideWebElement(theLinksInsideNewsContent);
    }
}
