package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import org.json.JSONObject;

public class ParsingXMLResponse {
	
	@Test(description="firstTest")
	public void testXMLResponse() {
		//Aproach 1
		given()
		.when()
		  .get("https://mocktarget.apigee.net/xml")
		 .then()
		 .statusCode(200)
		 .header("Content-Length","141")
		 .body("root.city", equalTo("San Jose"))
		 .log().all();
	}
	@Test(description="secondTest")
	public void test2XMLResponse() {
		//Aproach 2
		SoftAssert softAssert = new SoftAssert();
		Response res=given()
				.when()
				  .get("https://mocktarget.apigee.net/xml");
		
//		res .then()
//		 .statusCode(200)
//		 .header("Content-Length","141")
//		 .body("root.city", equalTo("San Jose"))
//		 .log().all();
		String header=res.getHeader("Content-Length");
		int statusCode=res.getStatusCode();
		String city = res.xmlPath().get("root.city").toString();

		Assert.assertEquals(statusCode, 200);
		softAssert.assertEquals(header,"141","bad header response");
		softAssert.assertEquals(statusCode,200,"wrong status code");
		softAssert.assertEquals(city,"San Jose","wrong city code");
		softAssert.assertAll();
		
	}
	
	@Test(description="fourthTest")
	public void test3XMLResponse() {
		//Aproach 3
		SoftAssert softAssert = new SoftAssert();
		Response res=given()
				.when()
				  .get("https://mocktarget.apigee.net/xml");
		
        XmlPath xmlObj=new XmlPath(res.asString());
        
       List<String> info=   xmlObj.getList("root");
       String city=xmlObj.getString("root.city");
       System.out.println(info.size());
       
       softAssert.assertEquals(city, "San Jose");
		
		softAssert.assertAll();
		
	}
	

}
