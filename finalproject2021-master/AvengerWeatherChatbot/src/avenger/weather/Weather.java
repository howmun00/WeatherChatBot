package avenger.weather;

import java.util.Map;

public class Weather {
    private String main;
    private String description;
    private double temp;
    private double min;
    private double max;
    private double feelsLike;
    private double windSpeed;
    private Location location;

//  Constructor
    public Weather(Map<String, Object> mainMap, Map<String, Object> windMap, Map<String, Object> weatherMap) {
        this.main = (String) weatherMap.get("main");
        this.description = (String)  weatherMap.get("description");
        this.temp = (double)  mainMap.get("temp") ;
        this.min = (double) mainMap.get("temp_min");
        this.max = (double) mainMap.get("temp_max") ;
        this.feelsLike = (double) mainMap.get("feels_like");
        this.windSpeed = (double) windMap.get("speed");
    }
//	Getters and Setters
    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
    
    public void setLocation(String city) {
    	this.location = new Location(city);
    }
    
    public Location getLocation() {
    	return this.location;
    }
    
}