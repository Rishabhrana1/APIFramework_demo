package stepDesfination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.Location;
import Pojo.addPlace;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinations extends Utils {

	
	RequestSpecification Res;
	ResponseSpecification responseSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_ID;
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String Lang, String Addres) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//RestAssured.baseURI= "https://rahulshettyacademy.com";
		//using restassured to add place usinf requestSpecbuilder () class
		//RequestSpecification is used for giving request 
		//ResponseSpecification is used for getting response
		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 Res = given().spec(requestSpecification())
				.body(data.addPlacePayLoad(name, Lang, Addres));
 
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String method) {
	    // constructor will be called with valueOf(resource) which you pass
		APIResources resAPI=APIResources.valueOf(resource);
		System.out.println(resAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
		{
		 response	= Res.when().post(resAPI.getResource());   //.then().spec(responseSpec).extract().response();
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response	= Res.when().get(resAPI.getResource());
		}

	}
	@Then("the API call is success with status code 200")
	public void the_api_call_is_success_with_status_code_200() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);

	}
	
	/*@And("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expecvalue) {
	    // Write code here that turns the phrase above into concrete actions
		
		String Resp=   response.asString();
		System.out.println(Resp);
		 js = new JsonPath(Resp);
		
		
		assertEquals(js.get(keyvalue), expecvalue);
	  //  throw new io.cucumber.java.PendingException();
	}
	*/
	

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expec_name, String resource) throws IOException {
	  
		place_ID=jsonParse(response, "place_id");
		//place_id = js.get("place_id");
		System.out.println("place_ID = " +place_ID);
		Res = given().spec(requestSpecification()).queryParam("place_id", place_ID);
		user_calls_with_post_http_request(resource, "GET");
		
		String name=jsonParse(response, "name ");
		
		assertEquals(name, expec_name);
		
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	  Res=  given().spec(requestSpecification()).body(data.deletPlacePayload(place_ID));
	}


}


