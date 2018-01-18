package com.my.map.domain;




import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;


@JsonRootName(value = "weatherElement")
public class Weather {
    
    @JsonProperty("elementName")
    private String elementName;
    private String elementValue;


    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
    
    public String getElementValue() {
        return elementValue;
    }
    @JsonSetter("elementValue")
    public void setElementValue(JsonNode  elementValue) {
        this.elementValue = elementValue.path("value").asText();
        
    }
    
    
    
    
}
