package allrestassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class FetchResponseDataConceptComplexjsonRA02 {
	
	@Test
	public void getSingleUser_fullUserDataTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response getRes = given()
		.header("Authorization", "Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.when()
		.get("public/v2/users");
		
		System.out.println("status code: "+getRes.statusCode());
		System.out.println("status line: "+getRes.statusLine());
		getRes.prettyPrint();
		
		JsonPath jsp = getRes.jsonPath();
		
		List<Object> allIds = jsp.getList("id");
		System.out.println(allIds);
		
		List<Object> allNames = jsp.getList("name");
		System.out.println(allNames);
		
		for(Object e: allIds) {
			System.out.println(e);
		}
		
		for(Object e: allNames) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void getFakeUserData_complexJsonTest() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Response getRes = given()
							.when()
								.get("/products");
		
		System.out.println(getRes.statusCode());
		System.out.println(getRes.statusLine());
		
		getRes.prettyPrint();
		
		JsonPath jsp = getRes.jsonPath();
		
		List<Object> allIds = jsp.getList("id");
		System.out.println(allIds);
		
		List<Object> allPrices = jsp.getList("price");
		System.out.println(allPrices);
		
		List<Object> allRatesList = jsp.getList("rating.rate");
		System.out.println(allRatesList);
		
		List<Object> allCountsList = jsp.getList("rating.count");
		System.out.println(allCountsList);
		
		for(int i=0; i<allIds.size(); i++) {
			Object id = allIds.get(i);
			Object price = allPrices.get(i);
			Object rate = allRatesList.get(i);
			
			System.out.println("ID:"+id + " Price:"+price + " Rate:"+rate);
		}
		
		Assert.assertTrue(allRatesList.contains(4.7f));
		
	}

}
