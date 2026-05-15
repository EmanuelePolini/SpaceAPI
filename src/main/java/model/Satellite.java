package model;

public class Satellite {

    private String name;
    private double speedKmS;
    private double distanceUA;
    private int yearsInSpace;

    public Satellite() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeedKmS() {
        return speedKmS;
    }

    public void setSpeedKmS(double speedKmS) {
        this.speedKmS = speedKmS;
    }

    public double getDistanceUA() {
        return distanceUA;
    }

    public void setDistanceUA(double distanceUA) {
        this.distanceUA = distanceUA;
    }

    public int getYearsInSpace() {
        return yearsInSpace;
    }

    public void setYearsInSpace(int yearsInSpace) {
        this.yearsInSpace = yearsInSpace;
    }
}
