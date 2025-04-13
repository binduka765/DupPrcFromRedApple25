package allrestassured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathParamsUsingDataProvider_RA02 {
	
	@DataProvider
	public Object[][] getUserData() {
		return new Object[][] {
			{"7810832"},
			{"7813904"},
			{"7813903"}
		};
	}
	
	@Test(dataProvider="getUserData")
	public void getUserData_PathParams_usingDataProvider(String userid) {
		RestAssured.baseURI = "https://gorest.co.in";
		
		given().log().all()
		.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.pathParam("userid", getUserData())
		.when().log().all()
		.get("/public/v2/users/{userid}/posts")
		.then().log().all()
		.assertThat()
		.statusCode(200);
				
	}

}
