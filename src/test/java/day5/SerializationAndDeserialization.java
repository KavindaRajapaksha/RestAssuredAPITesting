package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

//serialization pojo--->Json--->res
//Deserialization json--->pojo

public class SerializationAndDeserialization {
	
	@Test(description="firstTest")
	public void convertPojo2Json() throws JsonProcessingException {
		  Student data = new Student();
	        data.setId(1);
	        data.setName("John Doe");
	        data.setAge(20);
	        data.setGrade("A");
	        
	        //convert java object to json object(serialization)
	        
	        ObjectMapper objMapper=new ObjectMapper();
	        
	        String jsondata=  objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	        System.out.println(jsondata);
	}
	
	@Test(description="secondTest")
	public void convertJson2Pojo() throws JsonMappingException, JsonProcessingException {
		String jsonData="{\r\n"
				+ "  \"id\" : 1,\r\n"
				+ "  \"name\" : \"John Doe\",\r\n"
				+ "  \"age\" : 20,\r\n"
				+ "  \"grade\" : \"A\"\r\n"
				+ "}";
		 ObjectMapper stuObject=new ObjectMapper();
		 
		Student stu= stuObject.readValue(jsonData,Student.class);
		System.out.println(stu);
	}
	

}
