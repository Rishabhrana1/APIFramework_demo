package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.Location;
import Pojo.addPlace;

public class TestDataBuild {
	
	public addPlace addPlacePayLoad(String name, String Lang, String Add)
	{
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	

		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setName(name);
		//p.setPhn("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setLang(Lang);
		p.setAddress(Add);
		//p.setType(myList);
		p.setLocation(l);
		
		return p;
	}

	public String deletPlacePayload(String place_ID)
	{
		return place_ID;
	}
}
