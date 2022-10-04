package avenger.jsonParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import avenger.weather.Weather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jsonParser {
	
//	This method parser the Json String and create the Weather Object
	public Weather jsonStringParser(String jsonString) {
        //Transform the string received from the API in a MAP
        Map<String, Object> respMap = jsonToMap(jsonString.toString());
        //Breakdown to get all the information
        Map<String, Object> mainMap = (Map<String, Object >)respMap.get("main");
        Map<String, Object> windMap = (Map<String, Object >)respMap.get("wind");
        //One of the parts of Json is a list and them transform to map
        List<Map<String, Object >> weather = (List<Map<String, Object>>) (respMap.get("weather"));
        //Then you can transform as a MAP
        Map<String, Object> weatherMap = weather.get(0);

        //Here you can create an Weather Object to return it
        return new Weather(mainMap, windMap, weatherMap);
		
	}
	
//	Get the jsonString and extract to a MAP
   private static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }

   

}
