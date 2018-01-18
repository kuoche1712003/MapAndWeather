package com.my.map.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.my.map.domain.Location;
import com.my.map.domain.LocationDAO;

import com.my.map.repository.LocationDAORepository;

@Component
public class ScheduledTasks {
    
    @Autowired
    LocationDAORepository lrepo;
    
    
    @Scheduled(fixedRate = 300000)
    public void updatedata() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        String xml = restTemplate.getForObject("http://opendata.cwb.gov.tw/opendataapi?dataid=O-A0001-001&authorizationkey=CWB-849CAA88-0A70-41E9-B763-7B1C95EC0B3D",String.class);
        String Pstring = XML.toJSONObject(xml).toString(4);
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       
        try {
            JsonNode root = jsonMapper.readTree(Pstring);
            JsonNode a = root.get("cwbopendata").get("location");
            ObjectReader reader = jsonMapper.readerFor(new TypeReference<List<Location>>() {
            });
            List<Location> lo = reader.readValue(a);
            List<LocationDAO> we = new ArrayList<LocationDAO>();
            new JsonToDAO().convert(lo, we);
            int datarow = lrepo.findByWeatherDAO_ObsTime(we.get(0).getWeatherDAO().get(0).getObsTime()).size(); 
            if( datarow > 0 )
            {
                System.out.println("資料已是最新");
            }else {
                lrepo.save(we);
                System.out.println("更新資料完畢");
            }
                
            
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }
}
