package postwithmultipleoptions05secondhalf;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTapiwithDifferentDataOptions {
	
	@Test
	public void bodyWithTypeText_Test1() {
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payLoad = "Hi, This is BinAutoGp";

		given().log().all()
			.contentType(ContentType.TEXT)
			.body(payLoad)
			.when().log().all()
			.post("/post")
			.then().log().all()
			.assertThat()
			.statusCode(200);
		
		
	}
	
	@Test
	public void bodyWithTypeJavaScript_Test2() {
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payLoad = "var data = {\n"
				+ "    key1: \"value1\",\n"
				+ "    key2: \"value2\"\n"
				+ "};\n"
				+ "var jsonBody = JSON.stringify(data);";

		given().log().all()
			.contentType("application/javascript")
			.body(payLoad)
			.when().log().all()
			.post("/post")
			.then().log().all()
			.assertThat()
			.statusCode(200);
		
		
	}
	
	@Test
	public void bodyWithTypeHTML_Test3() {
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payLoad = "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "  <title>Sample HTML Page</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "  <h1>Hello, Postman!</h1>\n"
				+ "  <p>This is a sample HTML page.</p>\n"
				+ "</body>\n"
				+ "</html>";

		given().log().all()
			.contentType(ContentType.HTML)
			.body(payLoad)
			.when().log().all()
			.post("/post")
			.then().log().all()
			.assertThat()
			.statusCode(200);
		
		
	}
	
	@Test
	public void bodyWithTypeXML_Test4() {
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payLoad = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<contacts>\n"
				+ "    <contact>\n"
				+ "        <name>John Doe</name>\n"
				+ "        <email>john.doe@example.com</email>\n"
				+ "        <phone>123-456-7890</phone>\n"
				+ "    </contact>\n"
				+ "</contacts>";

		given().log().all()
			.contentType(ContentType.XML)
			.body(payLoad)
			.when().log().all()
			.post("/post")
			.then().log().all()
			.assertThat()
			.statusCode(200);
		
		
	}
	/**
	 * in postman-->body tab-->form data
	 * give key nameof file - upload the file in value
	 * give another key name - give some name to the file
	 */
	@Test
	public void bodyWithMultiPart_Test5() {
		RestAssured.baseURI = "https://postman-echo.com";
		

		given().log().all()
			.contentType(ContentType.MULTIPART)
			.multiPart("filename", new File("/Users/binduk/Documents/dataDrivenApiTesting/newUser.csv"))
			.multiPart("name", "newUser")
			.when()
			.post("/post")
			.then()
			.assertThat()
			.statusCode(200);
		
		
	}
	
	@Test
	public void bodyWithMultiPartPDFfile_Test6() {
		RestAssured.baseURI = "https://postman-echo.com";
		

		given().log().all()
			.contentType("application/pdf")
			.multiPart("filename", new File(""))
			.multiPart("name", "")
			.when()
			.post("/post")
			.then()
			.assertThat()
			.statusCode(200);
		
		
	}
	

}
