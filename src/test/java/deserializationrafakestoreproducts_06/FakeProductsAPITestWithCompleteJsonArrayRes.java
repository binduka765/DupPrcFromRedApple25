package deserializationrafakestoreproducts_06;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FakeProductsAPITestWithCompleteJsonArrayRes {
	
	@Test
	public void getAllProducts_WithPojo_Deserialization() {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		//1.get All products using: Get
		Response getRes = given()
							.when()
							.get("/products");//serialization Not Applicable for get call
						
		getRes.prettyPrint();
		
		//De-serialization: json to pojo
		ObjectMapper om = new ObjectMapper();
		
		try {
			Product[] fprods = om.readValue(getRes.getBody().asString(), Product[].class);
		
			//iterating thru the product[]:
			for(Product p: fprods) {
				System.out.println("ID:"+p.getId());
				System.out.println("TITLE:"+p.getTitle());
				System.out.println("PRICE:"+p.getPrice());
				System.out.println("DESCRIPTION:"+p.getDescription());
				System.out.println("CATEGORY:"+p.getCategory());
				System.out.println("RATING RATE:"+p.getRating().getRate());
				System.out.println("RATING COUNT:"+p.getRating().getCount());
				
				System.out.println("====================================");
				
			}
		
		 System.out.println(fprods);
		
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
			
		
	}

}
