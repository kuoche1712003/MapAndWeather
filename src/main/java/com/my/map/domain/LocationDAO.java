package com.my.map.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;











@Entity

public class LocationDAO {
    @Id
    private String stationId;
    
    private String lat;
  
    private String lon;
    
    private String locationName;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="locationDAO",fetch = FetchType.EAGER)
    private List<WeatherDAO> weatherDAO;
    
    
    
    public String getStationId() {
        return stationId;
    }
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLon() {
        return lon;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
    public String getLocationName() {
        return locationName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
   
    public List<WeatherDAO> getWeatherDAO() {
        return weatherDAO;
    }
    public void setWeatherDAO(List<WeatherDAO> weatherDAO) {
        this.weatherDAO = weatherDAO;
    }
    
   
    
}
