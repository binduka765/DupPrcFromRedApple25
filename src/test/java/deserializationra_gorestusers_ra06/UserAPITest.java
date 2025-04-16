package deserializationra_gorestusers_ra06;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserAPITest {
	
	@Test
	public void createUserWith_LombokBuilderTC1() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		UserL ul = new UserL.UserLBuilder()
				//			.id(();
							.name("Kavya")
							.email("kavyaKul123@appmail.com")
							.gender("female")
							.status("active")
							.build();
		
		Response postRes = given().log().all()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
				.body(ul)//serialization happening:pojo/lombok to json
				.when().log().all()
					.post("/public/v2/users");
		
		postRes.prettyPrint();
		Object pResUserId = postRes.jsonPath().get("id");
		System.out.println(pResUserId);//expected obj
		
		System.out.println("==========================");
		
		//2.get a user using the userId: GET
		Response getRes = given().log().all()
		.header("Authorization","Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.when().log().all()
		.get("public/v2/users/"+pResUserId);
		
		getRes.prettyPrint();
		
		//De-serialization: json to pojo
		ObjectMapper om = new ObjectMapper();
			
		try {//actual obj
			UserL userRes = om.readValue(getRes.getBody().asString(), UserL.class);
			System.out.println(userRes.getId()+" "+userRes.getName()+" "+userRes.getEmail()+" "+userRes.getGender()+" "+userRes.getStatus());
			
			Assert.assertEquals(userRes.getId(), pResUserId);
			Assert.assertEquals(userRes.getName(), ul.getName());
			Assert.assertEquals(userRes.getEmail(), ul.getEmail());
			Assert.assertEquals(userRes.getGender(), ul.getGender());
			Assert.assertEquals(userRes.getStatus(), ul.getStatus());
				
				
			} catch (JsonMappingException e) {
					e.printStackTrace();
			} catch (JsonProcessingException e) {
					e.printStackTrace();
			}
	
	}

}
