package bookingapitests_ra03;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestfulBookerAuthTest_BeforeMethod03 {
	
	@Test
	public void getAuthTokenTest_tc1() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	Object tokenId = given().log().all()
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/alljsons/user.json"))
			.when().log().all()
			.post("/auth")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.extract()
			.path("token");
		
		System.out.println("tokenId ===> "+tokenId);
	
	}

}
