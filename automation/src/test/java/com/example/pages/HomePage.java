package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class HomePage {
    private WebDriver driver;


    private static final String MONEYCORP_URL = "https://www.moneycorp.com/en-gb/";
   public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMoneyCorpWebsite() {
        driver.get(MONEYCORP_URL);
    }

    public void changeLanguageAndRegion(String language, String region) throws InterruptedException {
        sleep(2000);
        Actions actions = new Actions(driver);
        WebElement flag = driver.findElement(By.xpath("//*[@id='language-dropdown-flag']//img"));
        WebElement country = driver.findElement(By.xpath("//span[@class=\"language\" and text()='"+language+"']/..//span[@class=\"country\" and text()='"+region+"']"));
        actions.click(flag);
        actions.moveToElement(country);
        actions.click();
        actions.perform();

    }
    public boolean isResultPageDisplayed(String region) throws InterruptedException {
        sleep(5);
        return driver.findElement(By.xpath("//button/span/img[@src=\"/globalassets/images/icons/flags/"+region.toLowerCase()+".svg\"]")).isDisplayed();
    }

    public void clickFindOutMoreForForeignExchangeSolutions() throws InterruptedException {

    }

    public void searchForKeyword(String keyword) throws InterruptedException {

    }


    public boolean areArticleLinksValid() throws InterruptedException {
        return false;
    }
}
