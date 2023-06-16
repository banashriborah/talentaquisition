const { Given, When, Then } = require('cucumber');
const { Builder, By, Key, until } = require('selenium-webdriver');

const driver = new Builder().forBrowser('chrome').build();

Given('I open the MoneyCorp website', async () => {
  await driver.get('https://www.moneycorp.com/en-gb/');
});

When('I change the language and region to {string} {string}', async (language, region) => {
  // Implementation to change the language and region
});

When('I click on {string} for Foreign exchange solutions', async (buttonText) => {
  // Implementation to click on the button for Foreign exchange solutions
});

When('I search for the word {string}', async (keyword) => {
  // Implementation to search for the keyword
});

Then('I should be on the result page', async () => {
  // Implementation to validate if on the result page
});

Then('I should see each article link starting with {string}', async (linkStart) => {
  // Implementation to validate each article link starts with the specified URL
});

Then('I close the browser', async () => {
  await driver.quit();
});
