package day7;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test(description="updateUserTest")
	public void updateUser(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "active");
		
        String baererToken="816c1188b416519f5b2b00276b023ce0ec66dde99dc3818f23cd89b33b29b039";
		
//        int id=(int) context.getAttribute("user_id");
        int id=(int) context.getSuite().getAttribute("user_id");
				given()
				  .headers("Authorization","Bearer "+baererToken)
				  .contentType("application/json")
				  .pathParam("id", id)
				  .body(data.toString())
				.when()
			      .put("https://gorest.co.in/public/v2/users/{id}")
			     .then()
			       .statusCode(200)
			       .log().all();
		
		System.out.println("Generated id :"+id);
	}
	
}
