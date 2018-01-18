package com.my.map.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.map.domain.LocationDAO;
import com.my.map.domain.WeatherDAO;
import com.my.map.repository.LocationDAORepository;
import com.my.map.repository.WeatherDAORepository;



@Controller
public class WeatherController {
    
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired 
    LocationDAORepository lrepo;
    
    @Autowired
    WeatherDAORepository wrepo;
    
    @RequestMapping(value="/findWeatherByLocationName")
    public @ResponseBody List<WeatherDAO> findWeatherByLocationName(@RequestParam String locationName){
        
        return lrepo.findByLocationName(locationName).get(0).getWeatherDAO();
    }
    @RequestMapping(value="/findByObsTime")
    public @ResponseBody WeatherDAO findByObsTime(@RequestParam String locationName, @RequestParam String obsTime) throws ParseException{
        format.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
        return wrepo.findByObsTimeAndLocationDAO_LocationName( format.parse(obsTime),locationName).get(0);
    }
    
}
