package service;
import model.VoyagerData;

public class VoyagerService {
	public VoyagerData getVoyagerData() {
		VoyagerData data = new VoyagerData();
		
		data.setName("Voyager 1");
		data.setDistanzaUA(160.5);
		data.setVelocitaKmS(10220);
		data.setYearsInSpace(55);
		
		return data;
	}
}
