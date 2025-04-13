package ra_allupdate_apis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserUpdateWithPOJO04 {
	//1.create a user: POST: fetch the user id
	//2.GET
	//3.Update a user: PUT: append the same userid
	
	public String getRandomEmailId() {
		return "apiTestAuto"+System.currentTimeMillis() +"@appmail.com";
	}
	
	@Test
	public void updateUserWith_POJO() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		GoRestUser user = new GoRestUser("Suni", getRandomEmailId(), "female","active");
		
		//1.create a user: POST
		Response postRes = given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.body(user)
			.when().log().all()
			.post("/public/v2/users");
		
		postRes.prettyPrint();
		
		//GET: the same userId
		JsonPath jsp = postRes.jsonPath();
		Object userId = jsp.get("id");
		
		System.out.println(userId);
		
		//2. update: PUT: update a user
		//new body to be updated to the user info: using setter method
		user.setName("Sunitha Williams");
		user.setStatus("inactive");
		
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.body(user)
			.when().log().all()
			.put("/public/v2/users/"+userId)
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.body("name", equalTo(user.getName()))
			.and()
			.body("status", equalTo(user.getStatus()));
		
	}
	
	
}
