package bookingapitests_ra03;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BookingAPIFeatureTestsUPDATEFAILING {
	Object tokenId;
	
	@BeforeMethod(enabled=false)
	public void getAuthTokenTest_tc1() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	 tokenId = given().log().all()
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/alljsons/user.json"))
			.when().log().all()
			.post("/auth")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.extract()
			.path("token");
		
		System.out.println("tokenId ===> "+tokenId);
	
	}
	
	@Test
	public void getBookingIdsTest_tc2() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response getRes = given().log().all()
							.contentType(ContentType.JSON)
							.when().log().all()
							.get("/booking")
							.then().log().all()
							.assertThat()
							.statusCode(200)
							.extract()
							.response();
		
        JsonPath jsp = getRes.jsonPath(); 
       List<Object> allBookingIds = jsp.getList("bookingid");
       System.out.println("total booking ids are: "+allBookingIds.size());
       
       for(Object e: allBookingIds) {
    	  Assert.assertNotNull(e);
       }
	}
	
	@Test
	public void getSingleBookingIdTest_tc3() {
		Object newBookingId = createBooking_tc4();
		
		//appending this booking id as a path param
		//And getting the same booking id
		given().log().all()
			.pathParams("bookingId", newBookingId)
			.when().log().all()
			.get("/booking/{bookingId}")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.body("firstname", equalTo("Kim"))
			.body("lastname", equalTo("Kardashian"))
			.body("bookingdates.checkin", equalTo("2018-01-01"))
			.body("additionalneeds", equalTo("Brunch"));
		
	}
	
	@Test
	public void updateBookingTest_tc5_FAILING() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking id: Post
		Object newBookingId = createBooking_tc4();
		
		//get the same booking id: GET
		given().log().all()
		.pathParams("bookingid", newBookingId)
		.when().log().all()
		.get("/booking/{bookingid}")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
		//update the same bookingid: PUT
		given().log().all()
		.pathParams("bookingid", newBookingId)
		.contentType(ContentType.JSON)
		.header("Cookie", "token="+tokenId)
		.body("{\n"
				+ "    \"firstname\" : \"BinAuto\",\n"
				+ "    \"lastname\" : \"Group\",\n"
				+ "    \"totalprice\" : 112,\n"
				+ "    \"depositpaid\" : true,\n"
				+ "    \"bookingdates\" : {\n"
				+ "        \"checkin\" : \"2018-01-01\",\n"
				+ "        \"checkout\" : \"2019-01-01\"\n"
				+ "    },\n"
				+ "    \"additionalneeds\" : \"Lunch\"\n"
				+ "}")
		.when().log().all()
		.put("/booking/{bookingid}")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.body("firstname", equalTo("BinAuto"))
		.body("lastname", equalTo("Group"));
//		.body("additionalneeds", equalTo("Lunch"));
	}
	
	//generic fn to create a booking id: not test annotation
	public Object createBooking_tc4() {
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
		return bookingId;
	}

}
