package updateuser_ra04;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import updateuser_ra04.UserLombok.UserLombokBuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateUserLTest {
	
	public String getRandomEmail() {
		return "BinAutoGp"+System.currentTimeMillis()+"@appmail.com";
	}
	
	@Test
	public void createAUser_WithplainLombok() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		//creating user using plain lombok
		UserLombok ul = new UserLombok("Kiran","Ki2025@appmail.com","female","active");
			
		//1.post:create a user:
		Response postRes = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(ul)
			.when().log().all()
			.post("/public/v2/users");
		
		postRes.prettyPrint();
		Object userId = postRes.jsonPath().get("id");
		System.out.println("user id created ==>"+userId);
		
		System.out.println("===========================");
		
		
		
	}
	
	@Test
	public void createUser_withLombokBuilder() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		//creating user obj using lombok Builder:
		UserLombok lb = new UserLombok.UserLombokBuilder()
				.name("Kiran")
				.email(getRandomEmail())
				.gender("female")
				.status("active")
				.build();
			
		//1.post:create a user:
		Response postRes = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(lb)
			.when().log().all()
			.post("/public/v2/users");
		
		postRes.prettyPrint();
		Object userId = postRes.jsonPath().get("id");
		System.out.println("user id created ==>"+userId);
		
		System.out.println("===========================");
		
		
		
	}

}
