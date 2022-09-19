package dummy.apis.testPackage;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import dummy.apis.utils.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PUT_JSONHolderPost_Test {

	Configuration config = Configuration.getInstance();

	Map<String, Object> map = new HashMap<String , Object>();
	
	public Map<String, Object> getMap(){
		map.put("id", 5);
		map.put("title", "I want to be a good man");
		map.put("body", "Be helpful");
		map.put("userId", 5);
		return map;
	}
	
	@Test
	public void putCall() {
		getMap();
		RestAssured
			.given()
			.baseUri(config.get("baseUrl"))
			.contentType(ContentType.JSON)
			.body(map)
			.log().all()
			.put(config.get("postsEndpoint")+"/"+ map.get("id"))
			.then()
			.log().all();
	}
}
