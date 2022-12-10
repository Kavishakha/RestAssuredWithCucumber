package StepDefs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDStepDefinitions {
	
	RequestSpecification request;
	Response response;
	Map<String, Object> MapObj;

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		response = request.get();
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		Assert.assertEquals(expResponseCode, response.getStatusCode());
	}
	
	@When("I perform the Post Operation for users {string} and Salary {int}")
	public void i_perform_the_Post_Operation_for_users_and_Salary(String uname, int salary) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		MapObj = new HashMap<String, Object>();
		
		MapObj.put("name", uname);
		MapObj.put("salary", salary);
		response = 		
		request.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.post("/create");
	}
}
