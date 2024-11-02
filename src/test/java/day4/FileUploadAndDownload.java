package day4;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

    @Test(description = "firstTest")
    public void singleFileUpload() {
        
        File myfile = new File("C:\\Users\\Kavinda S Rajapaksha\\Desktop\\doc\\New folder\\test1.txt");

        given()
            .multiPart("file", myfile)  
        .when()
            .post("http://localhost:8080/uploadFile")
        .then()
            .statusCode(403);  
    }
    
    @Test(description="secondTest")
    public void multipleFileUpload() {
    	File myfile1 = new File("C:\\Users\\Kavinda S Rajapaksha\\Desktop\\doc\\New folder\\test1.txt");
    	File myfile2 = new File("C:\\Users\\Kavinda S Rajapaksha\\Desktop\\doc\\New folder\\test2.txt");
    	 given()
         .multiPart("files", myfile1)
         .multiPart("files",myfile2)
         .contentType("multipart/form-data")
     .when()
         .post("http://localhost:8080/uploadFile")
     .then()
         .statusCode(403);  
    }
    
    @Test
     public void fileDownload() {
        
        

        given()
             
        .when()
            .get("http://localhost:8080/uploadFile")
        .then()
            .statusCode(403);  
    }
}
