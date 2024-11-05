package day6;

//Authentication
 ///Authentication : valid or not
// Autherization :access
//types: Basic,Digest,Preempive,Bearer token,oauth,API key
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import org.json.JSONObject;

public class Authentications {

	@Test(description="testOne")
	public void basicAuth() {
		given()
		  .auth().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(description="testTwo")
	public void digestAuth() {
		given()
		  .auth().digest("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(description="testThree")
	public void preemptiveAuth() {
		given()
		  .auth().preemptive().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(description="testFour")
	public void bearerTokenAuth() {
		
		String bearerToken="token";
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		.when()
		   .get("https://api.github.com/user/repos")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}
	
	@Test(description="testFive")
	public void OAuth1Authentication() {
		given()
		   .auth().oauth("consumerKey", "consumerSecrate", "accessToken", "tokenSecrate")
		.when()
		   .get("url")
		.then()
		   .statusCode(400);
	}
	
	@Test(description="testSix")
	public void OAuth2Authentication() {
		given()
		   .auth().oauth2("token")
		.when()
		   .get("https://api.github.com/user")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	
	@Test(description="testSeven")
	public void apiKeyAuthentication() {
	   given()
	     .queryParam("appid", "token")
	   .when()
	      .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
	   .then()
	      .statusCode(401)
	      .log().all();
	}
	
}
