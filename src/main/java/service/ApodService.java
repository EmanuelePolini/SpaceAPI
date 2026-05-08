package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.ApodData;

public class ApodService {
	private String callApodApi() {
		String urlString = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
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
	
	
	public ApodData getApodData() {
		String ApodData = callApodApi();
		
		String title = "";
		String explanation = "";
		String date = "";
		String url = "";
		
		try {
			ObjectMapper parser = new ObjectMapper();
			JsonNode jsonObject = parser.readTree(ApodData);
			
			title = jsonObject.get("title").asText();
			explanation = jsonObject.get("explanation").asText();
			date = jsonObject.get("date").asText();
			url = jsonObject.get("url").asText();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ApodData data = new ApodData();
		
		data.setTitle(title);
		data.setExplanation(explanation);
		data.setDate(date);
		data.setUrl(url);
		
		return data;
		
	}
}
