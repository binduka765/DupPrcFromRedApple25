package allrestassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FetchResData_NegativeScenarioWrongAuthTokenRA02 {
	
	@Test
	public void getErrorMesg_WrongAuthTokenTest() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		
		given().log().all()
			.header("Authorization", "Bearer binAuto25")
			.when().log().all()
			.get("/contacts")
			.then().log().all()
			.assertThat()
			.statusCode(401)
			.and()
			.body("error", equalTo("Please authenticate."));

	}
	@Test
	public void getErrorMesg_WrongAuthTokenTest_2() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		
		Object errorMesg = given().log().all()
			.header("Authorization", "Bearer binAuto25")
			.when().log().all()
			.get("/contacts")
			.then().log().all()
			.assertThat()
			.statusCode(401)
			.and()
			.extract()
			.path("error");
		
		System.out.println(errorMesg);
		Assert.assertEquals(errorMesg, "Please authenticate.");
		
			
	}
	
	@Test
	public void getSingleUser_FetchUserDataTest_3() {
RestAssured.baseURI = "https://gorest.co.in";
		
		
		Response getRes = given().log().all()
//			.header("Authorization", "token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2U2YjY0ZWUyYWUxMDAwMTNiMWZkNjEiLCJpYXQiOjE3NDMxNzMxOTh9.ZL7Pq0pB8Wc3XNVTsJxAq-x5FKFXBkMvcEFIpD7JRhM")
			.when().log().all()
			.get("/public/v2/users/7817908");
		
		System.out.println("status code: "+getRes.statusCode());
		System.out.println("status line: "+getRes.statusLine());
		getRes.prettyPrint();
		getRes.peek();
		
		JsonPath jsp = getRes.jsonPath();
		
		Object userId = jsp.get("id");
		System.out.println("user id: "+userId);
		
		Object userName = jsp.get("name");
		System.out.println("user name: "+userName);
		
		Object userEmail = jsp.get("email");
		System.out.println("user email: "+userEmail);
		
		Object userGender = jsp.get("gender");
		System.out.println("user gender: "+userGender);
		
		Object userStatus = jsp.get("status");
		System.out.println("user status: "+userStatus);
		
		jsp.get("status");
		
	}

}
