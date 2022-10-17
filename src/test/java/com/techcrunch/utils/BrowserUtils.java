package com.techcrunch.utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtils {
    public static void assertTheLinksInsideWebElement(List<WebElement> elements) {

        for (WebElement element : elements) {
            String url = element.getAttribute("href");
            Assert.assertTrue(url.startsWith("https://"));
        }

    }
}
