package service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import model.VoyagerData;
import utils.UnitConverter;
import utils.TimeUtils;

import client.NasaClient;

public class VoyagerService {
	
	public VoyagerData getVoyagerData() {
		
		//data di lancio v1
		LocalDate launchDate = LocalDate.of(1977, 9, 5);
		
		/********************************CALCOLO DISTANZA AU****************************************************/
		
		//voyager 1 viaggia a circa 17 km/s
		double speedKmS = 17;
		
		double seconds = TimeUtils.calculateDaysSinceLaunch(launchDate) * 24 * 60 *60;
		
		//calcoliamo quindi applicando la formula fisica distanza = velocita * tempo
		double distanceKm = speedKmS * seconds;
		
		//calcolo distanza percorsa in unità astronomiche (AU)
		double distanceAu = UnitConverter.kmToAu(distanceKm);
		
		//anni trascorsi dal lancio
		int years = (int) TimeUtils.calculateYearsSinceLaunch(launchDate);
		
		/**************************************************************************************/
		
		NasaClient client = new NasaClient();
		String nasaData = client.callApi();
		
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
