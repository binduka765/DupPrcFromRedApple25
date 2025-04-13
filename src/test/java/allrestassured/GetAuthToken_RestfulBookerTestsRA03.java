package allrestassured;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import allpojos.Credentials;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAuthToken_RestfulBookerTestsRA03 {
	
	@Test
	public void getAuthTokenTest_hardcodedReqPayLoadtc1() {//hardcoded bodyjson
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Object tokenId = given()
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "    \"username\" : \"admin\",\n"
					+ "    \"password\" : \"password123\"\n"
					+ "}")
			.when()
			.post("/auth")
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.extract()
			.path("token");
		
		System.out.println("token created==>" +tokenId);
		Assert.assertNotNull(tokenId);
		
	}
	
	@Test
	public void getAuthTokenTest_JsonFileAuthDotJsontc1() {//Filebodyjson
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
		
		System.out.println("token created==>" +tokenId);
		Assert.assertNotNull(tokenId);
		
	}
	//WIP: added jackson - databind lib - which converts pojo to json as well
	//==> does serialization
	@Test
	public void getAuthToken_usingPOJOclasstc3() {//using POJO class Object
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Credentials cred = new Credentials("admin", "password123");
		
		Object tokenId = given().log().all()
		.contentType(ContentType.JSON)
		.body(cred)//pojo to json serialization
		.when().log().all()
		.post("/auth")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.extract()
		.path("token");
		
		System.out.println("token created==>" +tokenId);
		Assert.assertNotNull(tokenId);
		
		
	}

}
