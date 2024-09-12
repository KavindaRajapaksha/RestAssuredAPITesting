package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


/*
 * given()
 * contentType,setCookies,add Auth,add params
 * 
 * when()
 * get post put delete
 * 
 * then()
 * validate status code ,extract response,extract headers,response body
 * 
 * */

public class HttpMethods {

	@Test
	public void getUser() {
		 given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
}
