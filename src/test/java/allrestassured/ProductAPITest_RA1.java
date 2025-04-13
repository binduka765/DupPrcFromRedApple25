package allrestassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ProductAPITest_RA1 {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://fakestoreapi.com";
	}
	
	@Test
	public void getFakeUser_TC1() {
		
		given()
		 .when().log().all()
		 .get("/products")
		 .then().log().all()
		 .assertThat()
		 .statusCode(200);
		
	}
	
	@Test
	public void getFakeUserProductsListSize_TC2() {
		
		given()
			.get("/products")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.assertThat()
			.statusLine("HTTP/1.1 200 OK")
			.and()
			.body("$.size()", equalTo(20));
		
			
	}
	@Test
	public void getFakeAPIProducts_withoutBDDTC3() {
		
	}

}
