package dummy.apis.testPackage;

import org.testng.annotations.Test;

import dummy.apis.utils.Configuration;
import io.restassured.RestAssured;

public class GET_JSONHolderComment_Test {

	Configuration config = Configuration.getInstance();
	
	@Test
	public void getCommentTestWithParameter() {
		RestAssured
			.given()
			.baseUri(config.get("baseUrl"))
			.param("postId", 1)
			.get(config.get("commentEndpoint"))
			.prettyPrint();
	}
	
}
