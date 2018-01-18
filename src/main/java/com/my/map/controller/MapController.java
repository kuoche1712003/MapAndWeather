package com.my.map.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.map.domain.LocationDAO;
import com.my.map.repository.LocationDAORepository;

@Controller
public class MapController {
    
    String apikey = "AIzaSyCCpMB_ht_wSqegI4r1X7hL0HP5ScK5Ayg";
    
    RestTemplate restTemplate = new RestTemplate();
    
    @Autowired
    LocationDAORepository lrepo;
    
    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value="/map")
    public String map() {
        return "map";
    }
    @RequestMapping(value="/location")
    public @ResponseBody List<LocationDAO> findLocation(){
        return lrepo.findAll();
    }
    
    @RequestMapping(value="/address")
    public @ResponseBody JsonNode address(@RequestParam String address) throws JsonProcessingException, IOException {
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        String baseurl = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
        String json = restTemplate.getForObject(baseurl+address+"&key="+apikey,String.class);
        ObjectMapper objm = new ObjectMapper();
       
        List<JsonNode> root = objm.readTree(json).findValues("location");
        
        System.out.println(objm.writeValueAsString(root));
        return root.get(0);
    }
}
