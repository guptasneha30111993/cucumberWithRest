package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;




import org.json.simple.JSONObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class CustumerStepDefinitions {

	private Response response;
    private RequestSpecification request;
	private JSONObject requestBody;

	@Given("^custumer details with header$")
	public void custumerdetailswithheader() {
		
		request = RestAssured.given();
		
		requestBody = new JSONObject();

		requestBody.put("FirstName", "Virender2");
		requestBody.put("LastName", "Singh2");
        requestBody.put("UserName", "simpleuser0012");
		requestBody.put("Password", "password12");
		requestBody.put("Email", "someuser2@gmail.com");

		
		request.given().header("Content-Type", "application/json");

		request.given().body(requestBody.toJSONString());
		
		request.log().all();

	}

	@When("^a user post the custumer details with header$")
	public void postthecustumerdetailswithheader() {

	response = request.when().post("http://restapi.demoqa.com/customer/register");
		

	}

	@Then("^show logs$")
	public void showlogs() {
        
		
		System.out.println("Status code is: "+response.statusCode());
		System.out.println("Body is: "+response.body().asString());
		response.then().log().all();

	}

}
