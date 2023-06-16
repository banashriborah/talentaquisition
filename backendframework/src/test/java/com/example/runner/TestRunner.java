package com.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/boredapi.feature",
        glue = "com.example.steps",
        plugin = {"html:target/cucumber-reports.html"}
//        tags = "@run"
)
public class TestRunner {
}