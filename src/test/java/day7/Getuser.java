package day7;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class Getuser {
	
	@Test(description="getUserTest")
	public void getUser(ITestContext context) {
		String baererToken="816c1188b416519f5b2b00276b023ce0ec66dde99dc3818f23cd89b33b29b039";
//		int id=(int) context.getAttribute("user_id");
		int id=(int) context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+baererToken)
		.pathParam("id", id)
		.when()
		  .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		  .statusCode(200)
		   .log().all();
	}

}
