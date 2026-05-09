package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import client.NasaClient;
import model.ApodData;

public class ApodService {
	
	public ApodData getApodData() {
		NasaClient client = new NasaClient();
		
		String apodJson = client.callApi();
		
		String title = "";
		String explanation = "";
		String date = "";
		String url = "";
		
		try {
			ObjectMapper parser = new ObjectMapper();
			JsonNode jsonObject = parser.readTree(apodJson);
			
			title = jsonObject.get("title").asText();
			explanation = jsonObject.get("explanation").asText();
			date = jsonObject.get("date").asText();
			url = jsonObject.get("url").asText();
			
			System.out.println("titolo: " + title);
			System.out.println("descrizione: " + explanation);
			System.out.println("data: " + date);
			System.out.println("url: " + url);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ApodData data = new ApodData();
		
		data.setTitle(title);
		data.setExplanation(explanation);
		data.setDate(date);
		data.setImageUrl(url);
		
		return data;
		
	}
}
