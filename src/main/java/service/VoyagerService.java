package service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.VoyagerData;

public class VoyagerService {
	
	private String callNasaApi() {
		String urlString = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
		String jsondata = "";
		
		try {
			
			@SuppressWarnings("deprecation")
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output="";
			
			while((output = reader.readLine()) != null) {
				jsondata += output;
			}
			
			reader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsondata;
	}
	
	public VoyagerData getVoyagerData() {
		
		/********************************CALCOLO DISTANZA ANNI LUCE****************************************************/
		
		//data di lancio voyager 1 (5 settembre 1977)
		LocalDate launchDate = LocalDate.of(1977, 9, 5);
		
		//calcoliamo i giorni trascorsi (sottrae i giorni che si contano ad oggi e i giorni che si contavano al lancio)
		long daysInSpace = ChronoUnit.DAYS.between(launchDate, LocalDate.now());
		
		//effettuiamo la conversione in secondi
		long secondsInSpace = daysInSpace * 24 * 60 * 60;
		
		//voyager 1 viaggia a circa 17 km/s
		double speedKmS = 17;
		
		//calcoliamo quindi applicando la formula fisica distanza = velocita * tempo
		double distanceKm = speedKmS * secondsInSpace;
		
		//km effettivi di una unità astronomica (AU)
		final double AU = 149597870.7;
		
		//conversione distanza da km a AU
		double distanceAu = distanceKm / AU;
		
		/**************************************************************************************/
		
		int currentYear = LocalDate.now().getYear();
		int years = currentYear - 1977;
		
		String nasaData = callNasaApi();
		
		String title = "";
		String date = "";
		
		try {
			ObjectMapper parser = new ObjectMapper();
			
			JsonNode jsonObject = parser.readTree(nasaData);
			
			title = jsonObject.get("title").asText();
			date = jsonObject.get("date").asText();
			
			System.out.println("Titolo: " + title);
			System.out.println("Data: " + date);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VoyagerData data = new VoyagerData();
		
		data.setName(title);
		data.setDistanceUA(distanceAu);
		data.setSpeedKmS(speedKmS);
		data.setYearsInSpace(years);
		
		return data;
	}
}
