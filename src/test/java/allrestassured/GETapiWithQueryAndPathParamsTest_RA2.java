package allrestassured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GETapiWithQueryAndPathParamsTest_RA2 {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://gorest.co.in";
	}
	
	@Test
	public void getUserWithQueryParams_TC1() {
		given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			.queryParam("name", "Abbott")
			.queryParam("status", "inactive")
				.when().log().all()
				.get("/public/v2/users")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
	
	}
	
	@Test
	public void getUserWithQueryParams_usingHashMapObj_TC2() {
		
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("name", "Abbott");
		queryMap.put("status", "inactive");
		
		given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			 .queryParams(queryMap)
				.when().log().all()
				.get("/public/v2/users")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
	
	}
	
	@Test
	public void getUserWithQueryParams_MapDotOfMethod_jdk9NewFeatureTC3() {
		
		Map<String, String> queryMap = Map.of(
											
				                           "name", "Abbott",
				                           "status", "inactive"
												);
		
		given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
			 .queryParams(queryMap)
				.when().log().all()
				.get("/public/v2/users")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
	
	}
	
	@Test
	public void getUserAPI_withPathParams() {
		
		given().log().all()
		.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.pathParam("userid", "7810832")
		.when().log().all()
		.get("/public/v2/users/{userid}/posts")
		.then().log().all()
		.assertThat()
		.statusCode(200);
				
		
	}


}
