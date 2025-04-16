package jway_jsonpath_ra07;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonPathTest {
	
	@Test
	public void getProductApiTest_FakeUserProductJsonPath() {
		
		RestAssured.baseURI = "https://fakestoreapi.com/";

		Response getRes = given().log().all()
							.when().log().all()
							.get("/products");
		
		String jsonRes = getRes.asString();
		System.out.println(jsonRes);
		
		Object priceList = JsonPath.parse(jsonRes).read("$[?(@.price>50)].price");
		System.out.println(priceList);
		
		List<Number> idsList = JsonPath.parse(jsonRes).read("$[?(@.price>50)].id");
		System.out.println(idsList);
		
		Object titlesList = JsonPath.parse(jsonRes).read("$[?(@.price>50)].title");
		System.out.println(titlesList);
		
		Object rateList = JsonPath.parse(jsonRes).read("$[?(@.price>50)].rating.rate");
	    System.out.println(rateList);
	    
	    Object countList = JsonPath.parse(jsonRes).read("$[?(@.price>50)].rating.count");
	    System.out.println(countList);
	    
	    for(int i=0; i<idsList.size();i++) {
	    	System.out.println(idsList.get(i)+" "+priceList);
	    }
	
	}
	//$[?(@.rating.rate<3)].id --write java code for this
	@Test
	public void productApiTest_ConditionalExamples_WithTwoAttris() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Response getRes = given().log().all()
				.when().log().all()
				.get("/products");
		
		String jsonRes = getRes.asString();
		System.out.println(jsonRes);
		
		DocumentContext docCtx = JsonPath.parse(jsonRes);
		List<Map<String, Object>> jewelTitAndPriceList = docCtx.read("$[?(@.category == 'jewelery')].['title', 'price']");
		System.out.println(jewelTitAndPriceList.size());
		System.out.println(jewelTitAndPriceList);
		
		for(Map<String, Object>product : jewelTitAndPriceList) {
			String title = (String) product.get("title");
			Number price = (Number) product.get("price");
			System.out.println("jewelry title:"+title);
			System.out.println("jewelry price:"+price);
			System.out.println("--------------------");
		}
	
	}
	
	
	@Test
	public void productApiTest_ConditionalExamples_WithThreeAttris() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Response getRes = given().log().all()
				.when().log().all()
				.get("/products");
		
		String jsonRes = getRes.asString();
		System.out.println(jsonRes);
		
		DocumentContext docCtx = JsonPath.parse(jsonRes);
		
		List<Map<String, Object>> jewelTitAndPriceList = docCtx.read("$[?(@.category == 'jewelery')].['title', 'price','id']");
		System.out.println(jewelTitAndPriceList.size());
		System.out.println(jewelTitAndPriceList);
		
		for(Map<String, Object>product : jewelTitAndPriceList) {
			String title = (String) product.get("title");
			Number price = (Number) product.get("price");
			Number Id = (Number) product.get("id");
			System.out.println("jewelry title:"+title);
			System.out.println("jewelry price:"+price);
			System.out.println("jewelry id:"+Id);
			
			System.out.println("--------------------");
		}
	
	}
	@Test
	public void productApiTest_ConditionalExamples_WithFourAttris() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Response getRes = given().log().all()
				.when().log().all()
				.get("/products");
		
		String jsonRes = getRes.asString();
		System.out.println(jsonRes);
		
		DocumentContext docCtx = JsonPath.parse(jsonRes);
		
		List<Map<String, Object>> jewelTitAndPriceList = docCtx.read("$[?(@.category == 'jewelery')].['title', 'price','id','category']");
		System.out.println(jewelTitAndPriceList.size());
		System.out.println(jewelTitAndPriceList);
		
		for(Map<String, Object>product : jewelTitAndPriceList) {
			String title = (String) product.get("title");
			Number price = (Number) product.get("price");
			Number Id = (Number) product.get("id");
			String prodCategory = (String) product.get("category");
			System.out.println("jewelry title:"+title);
			System.out.println("jewelry price:"+price);
			System.out.println("jewelry id:"+Id);
			System.out.println("jewelry category:"+prodCategory);
			
			System.out.println("--------------------");
		}
	
	}
}
