package restassured_homework;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchUserIdsGoRest03 {
	
	//CRUD tests
	
	@Test
	public void createNewUserTest_WithJSONFiletc1() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		Object userId = given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.body(new File("src/test/resources/alljsons/gorest_user.json"))
			.when().log().all()
			.post("/public/v2/users")
			.then().log().all()
			.assertThat()
			.statusCode(201)
			.and()
			.extract()
			.path("id");
		
		System.out.println("user created: "+userId);
		Assert.assertNotNull(userId);
	
	}
	
	@Test
	public void getAllUserIdsTest_tc2() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response getRes = given().log().all()
							.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
							.contentType(ContentType.JSON)
							.when().log().all()
							.get("/public/v2/users");
		
		JsonPath jsp = getRes.jsonPath();
		
		List<Object> allUsersIdsList = jsp.getList("id");
		
		System.out.println(allUsersIdsList);
		
		for(Object e: allUsersIdsList) {
			Assert.assertNotNull(e);
		}
		
	}
	
	@Test
	public void getSingleUserTest_tc3() {
		
	}

}
