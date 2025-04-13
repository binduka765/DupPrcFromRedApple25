package allrestassured;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class QueryParams_usingDataProviderTest_RA02 {
	
	@DataProvider
	public Object[][] getQueryParamData() {
		return new Object[][] {
	{"Sunita Pothuvaal LLD", "active"},
	{"Kumari Varman", "inactive"},

		};	
	
	}
	
	@Test(dataProvider="getQueryParamData")
	public void getUserWithQueryParams_MapDotOfMethod_jdk9NewFeatureTC3(String name, String status) {
				
		
		
	given().log().all()
			.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
			.contentType(ContentType.JSON)
				
			.queryParam(name, getQueryParamData())
			.queryParam(status,getQueryParamData() )
		
				.when().log().all()
				.get("/public/v2/users")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
	
	}

}
