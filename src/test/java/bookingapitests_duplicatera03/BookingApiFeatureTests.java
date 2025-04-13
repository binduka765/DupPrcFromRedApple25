package bookingapitests_duplicatera03;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BookingApiFeatureTests {
	
	Object tokenId;
	
	@BeforeMethod
	public void getAToken() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	 tokenId = given()
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/alljsons/auth.json"))
			.when()
			.post("/auth")
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.extract()
			.path("token");
		
		System.out.println("token generated: "+tokenId);
		Assert.assertNotNull(tokenId);
		
	}
	
	@Test
	public void getAllBookingidsTest_tc1() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response getRes = given()
			.when()
			.get("/booking")
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.extract()
			.response();
		
		JsonPath jsp = getRes.jsonPath();
		List<Object> allBookingIds = jsp.getList("bookingid");
		System.out.println("total booking ids: "+allBookingIds.size());
		
		for(Object e: allBookingIds) {
			System.out.println(e);
		}		
	}
	
	@Test
	public void getSingleBookingIdTest_tc2() {
		//pre-requisite: create booking:POST
		Object newBookingId = createABooking();
		
		//get the same booking: GET and use PathParam()
		given()
		 	.contentType(ContentType.JSON)
		 		.pathParam("bookingid", newBookingId)
		 		.when().log().all()
		 		.get("booking/{bookingid}")
		 		.then().log().all()
		 		.assertThat()
		 		.statusCode(200)
		 		.and()
		 		.body("firstname", equalTo("Kim"))
		 		.and()
		 		.body("bookingdates.checkin", equalTo("2018-01-01"));
	}
	
	@Test
	public void createBookingTest_tc3() {
		Assert.assertNotNull(createABooking());
	}
	
	@Test
	public void updateBookingTest_tc4() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking: POST
		Object newBookingId = createABooking();
		
		//get the same booking id: GET
		//get the same booking: GET and use PathParam()
				given()
				 	.contentType(ContentType.JSON)
				 		.pathParam("bookingid", newBookingId)
				 		.when().log().all()
				 		.get("booking/{bookingid}")
				 		.then().log().all()
				 		.assertThat()
				 		.statusCode(200);
				 						
		//update the same booking id: PUT
				given().log().all()
				.header("Cookie", "token="+tokenId)
			 	.contentType(ContentType.JSON)
			 		.pathParam("bookingid", newBookingId)
			 		.body(new File("./src/test/resources/alljsons/restbookerupdateuser.json"))
			 		.when().log().all()
			 		.put("booking/{bookingid}")
			 		.then().log().all()
			 		.assertThat()
			 		.statusCode(200)
			 		.and()
			 		.body("firstname", equalTo("Bin"))
			 		.and()
			 		.body("lastname", equalTo("Automation"))
			 		.and()
			 		.body("additionalneeds", equalTo("Lunch"));
		
	}
	
	@Test
	public void partialUpdateBookingTest_tc5() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking: POST
		Object newBookingId = createABooking();
		
		//get the same booking id: GET
		//get the same booking: GET and use PathParam()
				given()
				 	.contentType(ContentType.JSON)
				 		.pathParam("bookingid", newBookingId)
				 		.when().log().all()
				 		.get("booking/{bookingid}")
				 		.then().log().all()
				 		.assertThat()
				 		.statusCode(200);
				 						
		//partial update the same booking id: PATCH
				given().log().all()
				.header("Cookie", "token="+tokenId)
			 	.contentType(ContentType.JSON)
			 		.pathParam("bookingid", newBookingId)
			 		.body("{\n"
			 				+ "    \"firstname\" : \"James\",\n"
			 				+ "    \"lastname\" : \"Brown\"\n"
			 				+ "}")
			 		.when().log().all()
			 		.patch("booking/{bookingid}")
			 		.then().log().all()
			 		.assertThat()
			 		.statusCode(200)
			 		.and()
			 		.body("firstname", equalTo("James"))
			 		.and()
			 		.body("lastname", equalTo("Brown"));
		
	}
	
	@Test
	public void deleteBookingTest_tc6() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking: POST
		Object newBookingId = createABooking();
		
		//get the same booking id: GET
		//get the same booking: GET and use PathParam()
				given()
				 	.contentType(ContentType.JSON)
				 		.pathParam("bookingid", newBookingId)
				 		.when().log().all()
				 		.get("booking/{bookingid}")
				 		.then().log().all()
				 		.assertThat()
				 		.statusCode(200);
				 						
		//delete the same booking id: DELETE
				given().log().all()
				.header("Cookie", "token="+tokenId)
			 	.contentType(ContentType.JSON)
			 		.pathParam("bookingid", newBookingId)
			 		.when().log().all()
			 		.delete("booking/{bookingid}")
			 		.then().log().all()
			 		.assertThat()
			 		.statusCode(201);
		
	}
	//creating a generic test: create a booking to be called in the caller class
	public Object createABooking() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Object bookingId = given().log().all()
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/alljsons/restfulbookeruser.json"))
			.when().log().all()
			.post("/booking")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.and()
			.extract()
			.path("bookingid");
		
		System.out.println("booking id generated: "+bookingId);
		Assert.assertNotNull(bookingId);
		return bookingId;
		
	}

}
