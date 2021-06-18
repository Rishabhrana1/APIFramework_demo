Feature: validating place API's
@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add place Payload with "<name>" "<language>" "<address>"
	When user calls "addplaceAPI" with "Post" http request
	Then the API call is success with status code 200
	#And verify place_id created maps to "<name>" using "getplaceAPI"
	
	
Examples:
	|name	|language	|address	|
	|AAA	|ENG		|Jogiwala	|
	|BBB	|Hindi		|Rispana	|

@DeletePlace	
Scenario: verify if delete place functionality is working
	
	Given DeletePlace Payload
	When user calls "deleteplaceAPI" with "Post" http request
	Then the API call is success with status code 200
	