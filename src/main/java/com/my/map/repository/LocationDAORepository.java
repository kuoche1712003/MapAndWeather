package com.my.map.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.map.domain.LocationDAO;


public interface LocationDAORepository extends JpaRepository<LocationDAO, String>{
    public List<LocationDAO> findByLocationName(String locationName);
    public List<LocationDAO> findByWeatherDAO_ObsTime(Date obsTime);
    public List<LocationDAO> findByLocationNameAndWeatherDAO_ObsTime(String locationName ,Date obsTime);
    
}
