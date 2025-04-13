package fakeuserapi_lombokra_04;

import org.testng.annotations.Test;

import fakeuserapi_lombokra_04.User.Address;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateFakeUserTest {
	
	public String getRandomEmail() {
		return "ShilpAutoGp"+System.currentTimeMillis()+"@25appmail.com";
	}
	
	@Test
	public void createUserTest_plainLombok() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		//creating a user obj using lombok
		User.Address.Geolocation geolocation = new User.Address.Geolocation("-98.900", "987.999");
		
		User.Address address = new User.Address("Bangalore", "new road", 9090, "98789", geolocation);
		
		User.Name name = new User.Name("Sonia", "Sharma");
		
		User user = new User("sonia@appmail.com", "soniasharma", "sonia@123", "9898-9090-987", name, address);
		
		
		ValidatableResponse postRes = given().log().all()
			.body(user)
			.when().log().all()
			.post("/users")
			.then().log().all()
			.assertThat()
			.statusCode(200);
	}
	
	@Test
	public void createUserTest_LombokBuilder() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
	User.Address.Geolocation geolocation = new User.Address.Geolocation.GeolocationBuilder()
		.lat("-90.899")
		.longitude("876.33")
		.build();
		
	User.Address address = new User.Address.AddressBuilder()
													.city("Pune")
													.street("old road")
													.number(9899)
													.zipcode("98779")
													.geolocation(geolocation)
													.build();
	
	User.Name name = new User.Name.NameBuilder()
								.firstname("Shilpa")
								.lastname("Shetty")
								.build();
	
			                        
User user =	new User.UserBuilder()
						.email("shilP@25appmail.com")
						.username("Shilpa@123")
						.password("shilPa@2025")
						.phone("5102998723")
						.name(name)
						.address(address)
						.build();
					
	
		given().log().all()
		.body(user)
		.when().log().all()
		.post("/users")
		.then().log().all()
		.assertThat()
		.statusCode(200);
	}

}
