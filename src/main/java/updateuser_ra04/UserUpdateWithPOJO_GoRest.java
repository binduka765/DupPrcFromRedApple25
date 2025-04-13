package updateuser_ra04;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserUpdateWithPOJO_GoRest {
	
	//1.create a user: POST: fetch the user id
	//2.GET
	//3.update a user: PUT
	public String getRandomEmail() {
		return "apiAutoGroup"+System.currentTimeMillis()+"@appmail.com";
	}
	
	@Test
	public void updateUserWith_POJO() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		User user = new User("Kiran",getRandomEmail(),"female","active");
		
		//1.post: create a user
		Response postRes = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(user)
				.when().log().all()
				.post("public/v2/users");
		
		postRes.prettyPrint();
		
		Object userId = postRes.jsonPath().get("id");
		System.out.println("user id created==>"+userId);
		
		System.out.println("==========================");
		
		//2.user update:PUT:
		//set the updated body of the user
		user.setName("KiranMayee");
		user.setStatus("inactive");
		
		
		given().log().all()
		.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.contentType(ContentType.JSON)
		.body(user)
			.when().log().all()
			.put("/public/v2/users/"+userId)
			.then().log().all()
			.assertThat()
			.statusCode(200)
			 .and()
			 .body("id", equalTo(userId))
			 .and()
			 .body("name", equalTo(user.getName()))
			 .and()
			 .body("status", equalTo(user.getStatus()));
					
	}
	

}
