package com.my.map.util;

import java.util.ArrayList;
import java.util.List;

import com.my.map.domain.Location;
import com.my.map.domain.LocationDAO;
import com.my.map.domain.Weather;
import com.my.map.domain.WeatherDAO;

public class JsonToDAO {
    public void convert( List<Location> location, List<LocationDAO> locationDAO ){
        for( Location l : location )
        {
            WeatherDAO wedao = new WeatherDAO();
            for( Weather we : l.getWeather() )
            {
                switch (we.getElementName())
                {
                case "ELEV":
                    wedao.setELEV(we.getElementValue());
                    break;
                case "WDIR":
                    wedao.setWDIR(we.getElementValue());
                    break;
                case "WDSD":
                    wedao.setWDSD(we.getElementValue());
                    break;
                case "TEMP":
                    wedao.setTEMP(we.getElementValue());
                    break;
                case "HUMD":
                    wedao.setHUMD(we.getElementValue());
                    break;
                case "PRES":
                    wedao.setPRES(we.getElementValue());
                    break;
                case "SUN":
                    wedao.setSUN(we.getElementValue());
                    break;
                case "H_24R":
                    wedao.setH_24R(we.getElementValue());
                    break;
                case "H_FX":
                    wedao.setH_FX(we.getElementValue());
                    break;
                case "H_XD":
                    wedao.setH_XD(we.getElementValue());
                    break;
                case "H_FXT":
                    wedao.setH_FXT(we.getElementValue());
                    break;
                }
            }
            List<WeatherDAO> wlist = new ArrayList<WeatherDAO>();
            LocationDAO lodao = new LocationDAO();
            lodao.setLat(l.getLat());
            lodao.setLocationName(l.getLocationName());
            lodao.setLon(l.getLon());
            lodao.setStationId(l.getStationId());
            wedao.setObsTime(l.getObsTime());
            wedao.setLocationDAO(lodao);
            wlist.add(wedao);
            lodao.setWeatherDAO(wlist);
            locationDAO.add(lodao);
        }
        
    }
}
