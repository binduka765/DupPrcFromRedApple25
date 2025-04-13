package allrestassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*
 * equalTo() : for json object -- {}
 * hasItem() : for jsonArray =>[{},{},{},....]
 */

public class FetchUserData_HasItemForJsonArrayRA02 {//7810832
	
	@DataProvider
	public Object[][] getUserData() {
		return new Object[][] {
			{"7817917"},
		};
	}
	
	@Test(dataProvider="getUserData")
	public void GoRestGetUserData_Test(String userid) {
		RestAssured.baseURI = "https://gorest.co.in";
		
		given().log().all()
		.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.pathParam("userid", userid)
		.when().log().all()
		.get("/public/v2/users/{userid}/posts")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and()
			.body("title", hasItem("Voveo molestiae aiunt amo depono."));
	}

}
