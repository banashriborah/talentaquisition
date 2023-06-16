const { Before, After } = require('cucumber');
const { Builder } = require('selenium-webdriver');

Before(async () => {
  const driver = new Builder().forBrowser('chrome').build();
  // Set up any preconditions or configurations before each scenario
});

After(async () => {
  // Perform any cleanup or teardown after each scenario
});
