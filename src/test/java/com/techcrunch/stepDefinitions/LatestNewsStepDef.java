package com.techcrunch.stepDefinitions;

import com.techcrunch.pages.HomePage;
import com.techcrunch.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LatestNewsStepDef {
    HomePage homePage = new HomePage();

    @Given("Navigate to home page")
    public void navigateToHomePage() {
        Driver.getDriver().get("https://techcrunch.com/");
    }

    @Then("check each news and verify that each news has an author")
    public void checkEachNewsAndVerifyThatEachNewsHasAnAuthor() {
        homePage.assertThatAllLatestNewsHasAuthor();
    }

    @Then("check each news and verify that each news has an Image")
    public void checkEachNewsAndVerifyThatEachNewsHasAnImage() {
        homePage.assertThatAllLatestNewsHasImage();
    }
}
