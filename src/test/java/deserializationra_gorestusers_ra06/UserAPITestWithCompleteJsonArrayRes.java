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

public class UserAPITestWithCompleteJsonArrayRes {
	
	@Test
	public void getAllUsersWith_LombokBuilderTC1() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		
		System.out.println("==========================");
		
		//1.get all users using: GET
		Response getRes = given().log().all()
		.header("Authorization","Bearer e6eec72969defa5772b22533590ebc176ed8184fb982e6582b5eff0f4cbf8cdd")
		.when().log().all()
		.get("public/v2/users/");//serialization NOT applicable for get call
		
		getRes.prettyPrint();
		
		//De-serialization: json to pojo
		ObjectMapper om = new ObjectMapper();
			
		try {//actual obj
			UserL[] userRes = om.readValue(getRes.getBody().asString(), UserL[].class);
			
			//to iterate the Array Loop: for Each
			for(UserL ul:userRes) {
				System.out.println("ID:"+ul.getId());
				System.out.println("NAME:"+ul.getName());
				System.out.println("EMAIL:"+ul.getEmail());
				System.out.println("GENDER:"+ul.getGender());
				System.out.println("STATUS:"+ul.getStatus());
				
				System.out.println("=======================");
			}
			
			System.out.println(userRes.length);	
				
			} catch (JsonMappingException e) {
					e.printStackTrace();
			} catch (JsonProcessingException e) {
					e.printStackTrace();
			}
	
	}


}
