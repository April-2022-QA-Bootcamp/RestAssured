package dummy.apis.testPackage;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;

public class GET_JSONHolderPost_Test {

	@Test(enabled = false)
	public void printResponse() {
		RestAssured
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.extract()
		.response()
		.prettyPrint();
	}
	
	@Test(enabled = false)
	public void assertStatusCode() {
		RestAssured
			.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			.then()
			.statusCode(201);
	}
	
	@Test(enabled = false)
	public void logRequestResponse() {
		RestAssured
		.given().log().all()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then().log().all();
	}
	
	@Test(enabled = true)
	public void assertion() {
		RestAssured
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		.log().all()
		.body("userId", equalTo(1))
		.body("id", equalTo(1))
		.body("title", containsString("sunt aut facere"));
	}
	
	@Test(enabled = false)
	public void assertContentType() {
		RestAssured
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.contentType(ContentType.JSON);
	}
	
	@Test(enabled = false)
	public void printHeaders() {
		Headers headers =
		RestAssured
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.extract().headers();
		
		System.out.println(headers.toString());
	}
	
	@Test(enabled = false)
	public void printHeader() {
		String header =
		RestAssured
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.extract()
		.header("Cache-Control");
		
		System.out.println(header);
	}
	
	@Test(enabled = true)
	public void assertAHeader() {
		RestAssured
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.header("Content-Encoding", equalTo("gzip"));
	}
}
