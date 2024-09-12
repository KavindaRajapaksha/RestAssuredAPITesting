package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class CookiesDemo {

	@Test(priority=1)
	public void testCookies() {
		given()
		
		.when()
		.get("https://www.google.co.uk/")
		.then()
		.cookie("AEC","AVYB7cqppZtBjIXmgUPC85F3wB6IPjYf3D4CxYmPALzXzsBr-V1ZcI3n9ng")
		.log().all();
	}
	@Test(priority=2)
	public void getCookies() {
	 Response res=	given()
		.when()
		.get("https://www.google.co.uk/");
	String cookie_val= res.getCookie("AEC");
//	System.out.print("Value===>"+cookie_val);
	Map<String,String> cookies=res.getCookies();
	
	System.out.println(cookies.keySet());
	for(String k:cookies.keySet()) {
		String cookie_value=res.getCookie(k); 
		System.out.println(k+"==== "+cookie_value);
	}
	}
	@Test(priority=3)
	public void getHeaders() {
	 given()
		.when()
		.get("https://www.google.co.uk/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Server","gws");
	 Response res=given()
				.when()
				.get("https://www.google.co.uk/");
	 System.out.println(res.getHeader("Date"));
	
	
	}
}
