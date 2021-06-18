package stepDesfination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	StepDefinations sD= new StepDefinations();
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//code to get place_id
		//execute this only when place_id is null
		if(StepDefinations.place_ID==null)
		{
		sD.add_place_payload_with("Rana", "ENG", "INDIA");
		sD.user_calls_with_post_http_request("addplaceAPI", "POST");
		sD.verify_place_id_created_maps_to_using("Rana", "Post");
		}
		
	}

}
