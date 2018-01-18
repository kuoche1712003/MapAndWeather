package com.my.map.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.my.map.domain.WeatherDAO;

public interface WeatherDAORepository extends JpaRepository<WeatherDAO, Long>{
    public List<WeatherDAO> findByObsTimeAndLocationDAO_LocationName(Date obsTime, String locationName);
}
