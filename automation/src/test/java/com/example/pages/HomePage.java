package com.example.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class HomePage {
    private WebDriver driver;
    private static Properties properties;

    private JavascriptExecutor js;

    public HomePage() {
        properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static final String MONEYCORP_URL ="https://www.moneycorp.com/en-gb/";

    private WebDriverWait wait;

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
        WebElement country = driver.findElement(By.xpath("//span[@class=\"language\" and text()='" + language + "']/..//span[@class=\"country\" and text()='" + region + "']"));
        actions.click(flag);
        actions.moveToElement(country);
        actions.click();
        actions.perform();

    }

    public void changeRegion() throws InterruptedException {
        sleep(2000);
        Actions actions = new Actions(driver);
        WebElement flag = driver.findElement(By.xpath("//*[@id='language-dropdown-flag']//img"));
        WebElement country = driver.findElement(By.xpath("//span[@class=\"language\" and text()='English']/..//span[@class=\"country\" and text()='USA']"));
        actions.click(flag);
        actions.moveToElement(country);
        actions.click();
        actions.perform();

    }

    public boolean isResultPageDisplayed(String region) throws InterruptedException {
        sleep(5);
        return driver.findElement(By.xpath("//button/span/img[@src=\"/globalassets/images/icons/flags/" + region.toLowerCase() + ".svg\"]")).isDisplayed();
    }

    public void isusaDisplayed() throws InterruptedException {
        sleep(5);
        Assert.assertTrue("USA is displayed ", driver.findElement(By.xpath("//button/span/img[@src='/globalassets/images/icons/flags/united-states-of-america.svg']")).isDisplayed());
    }

    public void scrollToView(String elementXpath) {

        WebElement element = driver.findElement(By.xpath(elementXpath));
        js = (JavascriptExecutor) driver;
        // Scroll the page until the element becomes visible
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickOnFindOutMore() throws InterruptedException {
        sleep(5);
        String findOutMoreXpath = "//div//h3[contains(text(),'Foreign exchange solutions')]/../a";
        scrollToView(findOutMoreXpath);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(findOutMoreXpath)));
    }

    public void untilPageIsDisplayed() {
        System.out.println(driver.getTitle());
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Foreign exchange solutions for your business')]")));
        Assert.assertTrue("Element is not visible", element.isDisplayed());
    }

    public void clickOnSearchboxAndEnterText(String text) {

        WebElement searchBox = driver.findElement(By.xpath("(//form//input[@id='nav_search'])[2]"));
        searchBox.click();
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void resultPageArrived() {
        wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Search Moneycorp')]")));
        Assert.assertTrue("Element is not visible", element.isDisplayed());

    }

    public void clickUntilNotVisibile() {

        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 20);
        By showMoreResults = By.xpath("//a[contains(text(),'Show more results')]");
        boolean isElementVisible = true;
        int counter = 0;
        while (isElementVisible && counter<3 ) {
            counter++;
            System.out.println(counter);
            // Wait for the element to be visible
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(showMoreResults));
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].click();", element);
            // Wait for 5 seconds
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // Check if the element is still visible
            isElementVisible = !driver.findElements(showMoreResults).isEmpty();


        }

    }

    public void validateLinks() {
        // Find all the articles on the page
        List<WebElement> articles = driver.findElements(By.xpath("//div[@class='results-wrapper']//div[@class='text']"));

        // Iterate through each article and validate the link
        for (WebElement article : articles) {
            WebElement link = article.findElement(By.tagName("a"));
            String href = link.getAttribute("href");
            if (href.startsWith("https://www.moneycorp.com/en-us/")) {
                System.out.println("Link validation passed for: " + href);
            } else {
                System.out.println("Link validation failed for: " + href);
            }
        }

    }

}
