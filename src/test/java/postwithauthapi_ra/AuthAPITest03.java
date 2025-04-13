package postwithauthapi_ra;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import allpojos.Credentials;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AuthAPITest03 {
	
	@Test
	public void createToken_withJSONhardcodedTest1() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Object tokenId = given().log().all()
							.contentType(ContentType.JSON)
							.body("{\n"
									+ "    \"username\" : \"admin\",\n"
									+ "    \"password\" : \"password123\"\n"
									+ "}")
							.when().log().all()
							.post("/auth")
							.then().log().all()
							.assertThat()
							.statusCode(200)
							.and()
							.extract()
							.path("token");
		
		System.out.println("auth token created is ===> "+tokenId);
		Assert.assertNotNull(tokenId);
		
	}
	@Test
	public void createToken_withJSONFileTest2() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Object tokenId = given().log().all()
							.contentType(ContentType.JSON)
							.body(new File("./src/test/resources/alljsons/auth.json"))
							.when().log().all()
							.post("/auth")
							.then().log().all()
							.assertThat()
							.statusCode(200)
							.and()
							.extract()
							.path("token");
		
		System.out.println("auth token created is ===> "+tokenId);
		Assert.assertNotNull(tokenId);
		
	}
	
	@Test
	public void createToken_withPOJOclassObjTest3() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		//WIP --not WIP since we exec using data bind jackson lib
		//creating the object of POJO:
		Credentials cred = new Credentials("admin", "password123");
		
		Object tokenId = given().log().all()
							.contentType(ContentType.JSON)
							.body(cred)//pojo to json => serialization:ObjectMapper(JacksonLib)
							.when().log().all()
							.post("/auth")
							.then().log().all()
							.assertThat()
							.statusCode(200)
							.and()
							.extract()
							.path("token");
		
		System.out.println("auth token created is ===> "+tokenId);
		Assert.assertNotNull(tokenId);
		
		//json --> pojo: De-serialization
		
	}
	
	

}
