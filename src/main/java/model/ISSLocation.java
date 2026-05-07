package model;

//questa classe conterrà i dati per monitorare la posizione della stazione spaziale internazionale in tempo reale
//l'API di riferimento con i dati aggiornati è questa: http://api.open-notify.org/iss-now.json

public class ISSLocation {
	private String latitude;
	private String longitude;
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	
}
