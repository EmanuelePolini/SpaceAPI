package service;

import java.util.ArrayList;
import java.util.List;

import model.Satellite;

public class SatelliteService {

    private List<Satellite> satellites;

    //build del satellite
    public SatelliteService() {

        satellites = new ArrayList<>();

        Satellite msn = new Satellite();
        msn.setName("Navicella Polini");
        msn.setSpeedKmS(676767676);
        msn.setDistanceUA(69696969);
        msn.setYearsInSpace(2000);

        satellites.add(msn);
    }

    //restituisce tutta la lista
    public List<Satellite> getAllSatellites() {
        return satellites;
    }

    //aggiunge un nuovo satellite
    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
    }
}
