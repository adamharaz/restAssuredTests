package getRequest;

import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

	@Test()
	public void testResponseCode() {
		int statusCode = get("https://jsonplaceholder.typicode.com/posts/1").getStatusCode();
		System.out.println("Status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test()
	public void testBody() {

		String data = get("https://jsonplaceholder.typicode.com/posts/1").asString();
		long time = get("https://jsonplaceholder.typicode.com/posts/1").getTime();
		System.out.println("Time is " + time);
		Assert.assertNotNull(data);
	}
}
