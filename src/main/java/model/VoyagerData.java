package model;
//questa classe si occupa di contenere i dati necessari alle richieste
//contiene nome, anni nello spazio,velocitòà, distanza

public class VoyagerData {
	private String name;
	private int yearsInSpace;
	private double velocitaKmS;
	private double distanzaUA;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYearsInSpace(int yearsInSpace) {
		this.yearsInSpace = yearsInSpace;
	}
	
	public void setVelocitaKmS(double velocitaKmS) {
		this.velocitaKmS = velocitaKmS;
	}
	
	public void setDistanzaUA(double distanzaUA) {
		this.distanzaUA = distanzaUA;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYears() {
		return yearsInSpace;
	}
	
	public double getVelocitaKmS() {
		return velocitaKmS;
	}
	
	public double getDistanzaUA() {
		return distanzaUA;
	}
}
