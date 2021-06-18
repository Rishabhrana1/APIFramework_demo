package resources;
//enum is special class in java which has collection of constants and methods
public enum APIResources {

	
	
	addplaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
