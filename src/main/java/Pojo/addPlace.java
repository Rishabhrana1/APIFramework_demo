package Pojo;

import java.util.List;

public class addPlace {

	private Location location;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public String getPhn() {
		return phone_number;
	}
	public void setPhn(String phn) {
		this.phone_number = phn;
	}
	*/
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLang() {
		return language;
	}
	public void setLang(String lang) {
		this.language = lang;
	}
	
	private int accuracy;
	private String name;
	private String phone_number;
	private List<String> types;
	/*public List<String> getType() {
		return types;
	}
	public void setType(List<String> type) {
		this.types = type;
	}*/
	private String website;
	private String language;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
