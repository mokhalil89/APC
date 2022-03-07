package resources;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.request.Webhook;

import java.io.*;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestApiClient {
	public Response get(String url) {
		return given().spec(new RequestSpecBuilder().build()).get(url);
	}

	public Response post(String url, Object payload) {
		return given().spec(new RequestSpecBuilder().setContentType(ContentType.JSON).build()).body(payload).post(url);
	}
}