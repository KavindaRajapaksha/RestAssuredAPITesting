package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PathAndQueryParameters {
	//https://reqres.in/api/users?page=2&id=5
	@Test(description="SMOD-TC",alwaysRun=true)
	public void testQueryAndPathParams() {
		given()
//		.pathParam("mypath1", "api")
		.pathParam("mypath", "users")//pathparams
		.queryParam("page", 2)//queryparams
		.queryParam("id", 5)
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
