package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import client.NasaClient;
import client.OpenNotifyClient;
import model.ISSLocation;

public class ISSService {
	
	public ISSLocation getISSLocation() {
		
		OpenNotifyClient client = new OpenNotifyClient();
		
		String ISSData = client.callISSApi();
		
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
