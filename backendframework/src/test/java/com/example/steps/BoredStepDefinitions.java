package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;

public class BoredStepDefinitions {

    private String type;
    private Response response;
    JSONObject[] jsonObjects;
    private static final String BASE_URL = "https://www.boredapi.com/api/";

    private String appropriateSuggestions;
    public static Response getSuggestedActivities(int count, String type) {
        String endpoint = BASE_URL + "activity?type=" + type + "&participants="+Integer.toString(count);
        return given()
                .when()
                .get(endpoint);
    }
    @Given("have a {string} activity")
    public void iHaveAActivity(String activityType) {
        this.type = activityType;
    }


    @When("request {} activities for {} people with type social")
    public void iRequestActivitiesForPeopleWithTypeSocial(int  numberOfActivities, int countOfPeople) {
        for (int i = 0; i <= numberOfActivities; i++) {
            response = getSuggestedActivities(countOfPeople, this.type);
            JsonPath jsonPath = response.jsonPath();
            String value = jsonPath.get("activity");
            System.out.println("Value: " + value);
            appropriateSuggestions=appropriateSuggestions+value;


        }

    }
    @Then("should receive appropriate suggestions")
    public void iShouldReceiveAppropriateSuggestions() {
        System.out.println(appropriateSuggestions);

    }


}
