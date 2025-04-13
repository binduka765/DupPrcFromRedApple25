package allrestassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ContactsListAPIgetTest_RA1 {
	
	@Test
	public void getContactApiTest_TC1() {
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		given()
			.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2M1MTlkMzFkNzY5YjAwMTNjZDI3YjkiLCJpYXQiOjE3NDExNDU2MzV9.OtPSd5Em9-CZMQ6lDteF5azjK4EJyB6nx6nPtAZzmmY")
			.when().log().all()
			.get("/contacts")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.assertThat()
			.statusLine("HTTP/1.1 200 OK")
			.and()
			.contentType(ContentType.JSON)
			.and()
			.body("$.size()", equalTo(5));
			
		
		
	}

}
