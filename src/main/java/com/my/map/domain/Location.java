package com.my.map.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;


@JsonRootName(value = "location")
public class Location {
   
    @JsonProperty("stationId")
    private String stationId;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("locationName")
    private String locationName;
    private Date obsTime;
  
    @JsonProperty("weatherElement")
    private List<Weather> weather;
    
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
    public  List<Weather> getWeather() {
        return weather;
    }
    public void setWeather( List<Weather> weather) {
        this.weather = weather;
    }
    public Date getObsTime() {
        return obsTime;
    }
    
    @JsonSetter("time")
    public void setObsTime(JsonNode obsTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+08:00'");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
        this.obsTime = format.parse(obsTime.path("obsTime").asText());
    }
}
