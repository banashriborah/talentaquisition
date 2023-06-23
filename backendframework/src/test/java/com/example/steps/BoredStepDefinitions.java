package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BoredStepDefinitions {

    private String type;
    private Response response;
    JSONObject[] jsonObjects;
    private static final String BASE_URL = "https://www.boredapi.com/api/";

    private String appropriateSuggestions;
    private List<String> myList;
    public static Response getSuggestedActivities(int count, String type) {
        String endpoint = BASE_URL + "activity?type=" + type + "&participants="+Integer.toString(count);
        System.out.println(endpoint);
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

        myList = new ArrayList<>();

        while (myList.size() < numberOfActivities) {
            response = getSuggestedActivities(countOfPeople, this.type);
            JsonPath jsonPath = response.jsonPath();
            String activity = jsonPath.get("activity");

            if (!myList.contains(activity)) {
                myList.add(activity);
            } else {
                System.out.println(myList);
                System.out.println("Element already exists in the list. Please enter a unique element.");
            }
        }
        System.out.println("List size reached "+Integer.toString(numberOfActivities)+" Elements: " + myList);
        Assert.assertEquals(myList.size(),numberOfActivities);

    }


    @Then("should receive appropriate suggestions")
    public void iShouldReceiveAppropriateSuggestions() {
        for (String suggestions : myList) {
            String str = String.valueOf(suggestions);
            System.out.println("activity: " + str);
        }

    }


}
