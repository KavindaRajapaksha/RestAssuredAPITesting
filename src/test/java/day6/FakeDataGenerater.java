package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGenerater {

	@Test(description="testOne")
	public void dataGenerator() {
		//https://github.com/DiUS/java-faker
		Faker faker = new Faker();

		String name = faker.name().fullName(); 
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName(); 

		String streetAddress = faker.address().streetAddress(); 
		String password=faker.internet().password();
		String userName=faker.name().username();
		System.out.println(name);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(streetAddress);
		System.out.println(userName);
		System.out.println(password);
	}
	
}
