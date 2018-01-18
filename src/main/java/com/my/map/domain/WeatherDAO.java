package com.my.map.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity

public class WeatherDAO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date obsTime;
    private String ELEV;
    private String WDIR;
    private String WDSD;
    private String TEMP;
    private String HUMD;
    private String PRES;
    private String SUN;
    private String H_24R;
    private String H_FX;
    private String H_XD;
    private String H_FXT;
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="locationId")
    private LocationDAO locationDAO; 
  
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getObsTime() {
        return obsTime;
    }
    public void setObsTime(Date obsTime) {
        this.obsTime = obsTime;
    }
    public String getELEV() {
        return ELEV;
    }
    public void setELEV(String ELEV) {
        this.ELEV = ELEV;
    }
    public String getWDIR() {
        return WDIR;
    }
    public void setWDIR(String WDIR) {
        this.WDIR = WDIR;
    }
    public String getWDSD() {
        return WDSD;
    }
    public void setWDSD(String WDSD) {
        this.WDSD = WDSD;
    }
    public String getTEMP() {
        return TEMP;
    }
    public void setTEMP(String TEMP) {
        this.TEMP = TEMP;
    }
    public String getHUMD() {
        return HUMD;
    }
    public void setHUMD(String HUMD) {
        this.HUMD = HUMD;
    }
    public String getPRES() {
        return PRES;
    }
    public void setPRES(String PRES) {
        this.PRES = PRES;
    }
    public String getSUN() {
        return SUN;
    }
    public void setSUN(String SUN) {
        this.SUN = SUN;
    }
    public String getH_24R() {
        return H_24R;
    }
    public void setH_24R(String H_24r) {
        this.H_24R = H_24r;
    }
    public String getH_FX() {
        return H_FX;
    }
    public void setH_FX(String H_FX) {
        this.H_FX = H_FX;
    }
    public String getH_XD() {
        return H_XD;
    }
    public void setH_XD(String H_XD) {
        this.H_XD = H_XD;
    }
    public String getH_FXT() {
        return H_FXT;
    }
    public void setH_FXT(String H_FXT) {
        this.H_FXT = H_FXT;
    }
    public LocationDAO getLocationDAO() {
        return locationDAO;
    }
    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }
    
   
    
    
    
    
}
