package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.ISSLocation;

public class ISSService {
	
	private String callISSApi() {
		String urlString = "http://api.open-notify.org/iss-now.json";
		String jsondata = "";
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output="";
			
			while((output = reader.readLine()) != null) {
				jsondata += output;
			}
			
			reader.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsondata;
	}
	
	
	public ISSLocation getISSLocation() {
		
		String ISSData = callISSApi();
		
		String latitude = "";
		String longitude = "";
		
		try {
			ObjectMapper parser = new ObjectMapper();
			JsonNode jsonObject = parser.readTree(ISSData);
			
			latitude = jsonObject.get("iss_position").get("longitude").asText();
			longitude = jsonObject.get("iss_position").get("latitude").asText();
			
			System.out.println("latitudine ISS: " + latitude);
			System.out.println("longitudine ISS: " + longitude);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		ISSLocation location = new ISSLocation();
		
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		
		return location;
	}
}
