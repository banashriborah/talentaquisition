package com.example.steps;

import com.example.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.addArguments("--enable-notifications");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
    }

    @Given("open the MoneyCorp website")
    public void openMoneyCorpWebsite() {
        homePage.openMoneyCorpWebsite();
    }


    @When("change the language and region to USA\\(English)")
    public void changeTheLanguageAndRegionToUSAEnglish() throws InterruptedException {
        homePage.changeRegion();
    }

    @Then("verify the region is displayed")
    public void verifyTheRegionIsDisplayed() throws InterruptedException {
        homePage.isusaDisplayed();
    }


    @And("click on find out more for Foreign exchange Solutions")
    public void clickOnFindOutMoreForForeignExchangeSolutions() throws InterruptedException {
        homePage.clickOnFindOutMore();
    }


    @Then("validate right page is arrived")
    public void validateRightPageIsArrived() {
        homePage.untilPageIsDisplayed();
    }

    @And("click on searchbox to find internationalpayments")
    public void clickOnSearchboxToFindInternationalpayments() {
        homePage.clickOnSearchboxAndEnterText("international payments");
    }

    @Then("validate result page is arrived")
    public void validateResultPageIsArrived() {
        homePage.resultPageArrived();
    }


    @And("click show more results until not available")
    public void clickShowMoreResultsUntilNotAvailable() throws InterruptedException {
        homePage.clickUntilNotVisibile();
    }


    @Then("verify all articles has link starting with")
    public void verifyAllArticlesHasLinkStartingWith() throws InterruptedException {
        homePage.validateLinks();
    }

    @And("i close browser")
    public void iCloseBrowser() {
        driver.quit();
    }


    @After
    public void tearDown() {
        // Quit the WebDriver instance after each scenario
        if (driver != null) {
            driver.quit();
        }
    }



}
