package model;
//questa classe si occupa di contenere i dati necessari alle richieste
//contiene nome, anni nello spazio,velocitòà, distanza

public class VoyagerData {
	private String name;
	private int yearsInSpace;
	private double speedKmS;
	private double distanceUA;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYearsInSpace(int yearsInSpace) {
		this.yearsInSpace = yearsInSpace;
	}
	
	public void setSpeedKmS(double speedKmS) {
		this.speedKmS = speedKmS;
	}
	
	public void setDistanceUA(double distanceUA) {
		this.distanceUA = distanceUA;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYearsInSpace() {
		return yearsInSpace;
	}
	
	public double getSpeedKmS() {
		return speedKmS;
	}
	
	public double getDistanceUA() {
		return distanceUA;
	}
}
