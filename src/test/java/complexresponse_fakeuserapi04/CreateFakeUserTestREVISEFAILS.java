package complexresponse_fakeuserapi04;

import org.testng.annotations.Test;

import complexresponse_fakeuserapi04.FakeUserLombok.Address.Geolocation;
import io.restassured.RestAssured;

public class CreateFakeUserTestREVISEFAILS {
	
	@Test
	public void createUserTest() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
//		Geolocation geoloc = new Geolocation("-98.900", "987.999");
		FakeUserLombok.Address.Geolocation = new Geolocation("-98.900", "987.999");
		
		Object geoloc = null;
	FakeUserLombok.Address address = new FakeUserLombok.Address("Bangalore", "new road", 9090, "9879", geoloc);
	FakeUserLombok.Name name = new FakeUserLombok.Name("Sonia", "Sharma");
//	FakeUserLombok user = new FakeUserLombok("Sonia@gmail.com", "SoniaSharma", "Sonia@123", "9898-9090-987", name, address);
	
	
		
	}

}
