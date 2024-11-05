package day7;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test(description="createUser")
	public void createUser(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String baererToken="816c1188b416519f5b2b00276b023ce0ec66dde99dc3818f23cd89b33b29b039";
		
		int id=given()
				  .headers("Authorization","Bearer "+baererToken)
				  .contentType("application/json")
				  .body(data.toString())
				.when()
			      .post("https://gorest.co.in/public/v2/users")
			      .jsonPath().getInt("id");
		
		System.out.println("Generated id :"+id);
          
//		context.setAttribute("user_id", id);//only within the test
		context.getSuite().setAttribute("user_id", id);//suite level
		
		
	}

}
