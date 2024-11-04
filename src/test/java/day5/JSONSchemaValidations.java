package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import org.json.JSONObject;

//json schema=.json xml schema=.xsd
public class JSONSchemaValidations {

	@Test(description="firstTest")
	public void jsonSchemaValidation() {
		given()
		
		.when()
		   .get("https://jsonplaceholder.typicode.com/posts")
		.then()
		  .statusCode(200)
		  .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
	}
	
}
