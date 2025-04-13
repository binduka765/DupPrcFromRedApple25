package postapiwithcreateusergorest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUserGoRestApiTest03 {
	
	@Test
	public void createGoRestUserTest_tc1() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		
		Object userId = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/alljsons/user.json"))
			.when().log().all()
			.post("/public/v2/users")
			.then().log().all()
			.assertThat()
			.statusCode(201)
			.and()
			.extract()
			.path("id");
			
		System.out.println("user id: "+userId);
		Assert.assertNotNull(userId);
		
	}

}
