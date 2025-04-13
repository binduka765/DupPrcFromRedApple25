package bookingapitests_ra03;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestfulBookerCreateBookingTest {
	
	@Test
	public void createBooking_tc4() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Object bookingId = given().log().all()
							.contentType(ContentType.JSON)
							.body(new File("./src/test/resources/alljsons/restfulbookeruser.json"))
							.when().log().all()
							.post("/booking")
							.then().log().all()
							.assertThat()
							.statusCode(200)
							.extract()
							.path("bookingid");
		
		System.out.println("booking id created: "+bookingId);
//		return bookingId;
	}

}
