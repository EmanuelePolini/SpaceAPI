package utils;

public class UnitConverter {
	
	private final static double AU = 149597870.7;
	
	public static double kmToAu(double km) {
		return km/AU;
	}
}
