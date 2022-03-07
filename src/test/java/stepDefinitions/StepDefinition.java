package stepDefinitions;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import pojo.request.Webhook;
import resources.APIResources;
import resources.Constants;
import resources.RestApiClient;

public class StepDefinition {
    private String endpointUrl;
    private Webhook webhook;
    private Response response;

    @Given("country name {string} in the path parameter")
    public void countryNameInThePathParameter(String countryName) {
        endpointUrl = Constants.BASE_URL + APIResources.Country.getResource() + countryName;
    }

    @When("calling Get API and the response received")
    public void callingGetAPIAndTheResponseReceived() {
        response = new RestApiClient().get(endpointUrl);
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int expectedResponseCode) {
        assertEquals(expectedResponseCode, response.getStatusCode());
    }

    @Given("url {string} in th payload")
    public void urlInThPayload(String urlInPayload) {
        webhook = new Webhook(urlInPayload);
    }

    @When("calling Post API and the response received")
    public void callingPostAPIAndTheResponseReceived() {
        String webhookUrl = Constants.BASE_URL + APIResources.Webhook.getResource();
        response = new RestApiClient().post(webhookUrl, webhook);
    }
}