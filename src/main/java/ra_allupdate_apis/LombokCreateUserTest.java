package ra_allupdate_apis;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LombokCreateUserTest {
	
	public String getRandomEmailId() {
		return "BinAuto"+System.currentTimeMillis()+"@25appmail.com";
	}
	
	@Test
	public void CreateUserWith_LombokTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		UserLombok userL = new UserLombok("Piyush", getRandomEmailId(), "male", "active");
		
		
		//1.create a user - post
		Response postRes = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(userL)
			.when().log().all()
			.post("/public/v2/users");
		
		postRes.prettyPrint();
		JsonPath jsp = postRes.jsonPath();
		Object userId = jsp.get("id");
		System.out.println("user id generated ===>> "+userId);
		
		System.out.println("==================================");
	
	}
	
	@Test
	public void createUser_WithLombokTest_tc2() {
		RestAssured.baseURI = "https://gorest.co.in";
	
	UserLombok UL = new UserLombok.UserLombokBuilder()
		.name("Piyush")
		.email(getRandomEmailId())
		.status("active")
		.gender("male")
		.build();
	
	Response postRes = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(UL)
			.when().log().all()
			.post("/public/v2/users");
		
		postRes.prettyPrint();
		JsonPath jsp = postRes.jsonPath();
		Object userId = jsp.get("id");
		System.out.println("user id generated ===>> "+userId);
	
	
	}

}
