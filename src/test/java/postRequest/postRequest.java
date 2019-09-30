package postRequest;

import static io.restassured.RestAssured.get;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postRequest {

	@Test
	public void RegistrationSuccessful() throws JSONException {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "foo");
		requestParams.put("body", "bar");
		requestParams.put("userId", "1");

		request.body(requestParams.toString());
		Response response = request.post();

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "200");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

	@Test()
	public void testBody() {

		String data = get("https://jsonplaceholder.typicode.com/posts").asString();
		long time = get("https://jsonplaceholder.typicode.com/posts").getTime();
		System.out.println("Time is " + time);
		Assert.assertNotNull(data);
	}
}
