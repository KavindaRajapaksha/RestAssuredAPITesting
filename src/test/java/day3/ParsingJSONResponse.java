package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import org.json.JSONObject;



public class ParsingJSONResponse {

	@Test(priority=1)
	public void testJsonResponse() {
		SoftAssert softAssert = new SoftAssert();
		//Approach1
//		given()
//		.contentType("ContentType.JSON")
//		.when()
//		.get("https://reqres.in/api/users?page=2")
//		.then()
//		.statusCode(200)
//		.body("data[1].last_name",equalTo("Ferguson"))
//		.log().all();//json path and validate field
		
		//Approach 2
		Response res=	given()
				.contentType("ContentType.JSON")
				.when()
				.get("https://reqres.in/api/users?page=2");
//		softAssert.assertEquals(res.getStatusCode(),200,"failed");
//		String val=res.jsonPath().get("data[1].last_name").toString();
//		softAssert.assertEquals(val, "Ferguson","failed");
//		softAssert.assertAll();
		//Approach 3 using json oobject
		JSONObject jo=new JSONObject(res.toString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			String names=jo.getJSONArray("data").getJSONObject(i).get("name").toString();
			System.out.println(names);
		}
		
	}
	
	
	
}
