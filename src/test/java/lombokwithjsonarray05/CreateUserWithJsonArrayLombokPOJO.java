package lombokwithjsonarray05;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
public class CreateUserWithJsonArrayLombokPOJO {
	
	@Test
	public void createUserWithJsonArrayPOJO() {
		
		RestAssured.baseURI = "https://postman-echo.com";
		
		User.UserData ud1 = new User.UserData(1, "abhiA@app.com", "Abbhi","Anand", "https://reqres.in/img/faces/3-image.jpg");
		User.UserData ud2 = new User.UserData(2, "soniaS@appmail.com", "Sonia", "Sharma", "https://reqres.in/img/faces/4-image.jpg");
		User.UserData ud3 = new User.UserData(3, "poojaT@app.com", "Pooja", "Tiwari", "https://reqres.in/img/faces/5-image.jpg");
		User.UserData ud4 = new User.UserData(4, "suryaA@appmail.com", "Surya", "Arya", "https://reqres.in/img/faces/6-image.jpg");
		User.UserData ud5 = new User.UserData(5, "praveenK@appmail.com", "Praveen", "Kishore", "https://reqres.in/img/faces/7-image.jpg");
		User.UserData ud6 = new User.UserData(6, "kavyaP@appmail.com", "Kavya", "Prema", "https://reqres.in/img/faces/8-image.jpg");
		
		
		User.Support us = new User.Support("https://reqres.in/support-heading", "keep ReqRes free, contributions towards server costs are appreciated!");
		
		User user = new User(1,
							 6,
							 12,
							 2, 
							 us, 
							 Arrays.asList(ud1, ud2, ud3, ud4, ud5, ud6)
							 );
		
		given().log().all()
		.contentType(ContentType.JSON)
		.body(user)
		.when().log().all()
		.post("/post")
		.then().log().all()
		.assertThat()
		.statusCode(200);
	}
	
	

}
