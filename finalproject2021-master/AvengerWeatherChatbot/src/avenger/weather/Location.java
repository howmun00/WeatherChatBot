package avenger.weather;

public class Location {
	String city;
	String country;
	
	public Location(String city) {
		this.city = city;
		this.country = "Ireland";
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

}

