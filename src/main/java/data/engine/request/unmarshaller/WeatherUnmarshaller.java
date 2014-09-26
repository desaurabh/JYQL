/*
 * Copyright 2014 masterOpti.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package data.engine.request.unmarshaller;

import data.engine.model.weather.*;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author masterOpti
 */
public class WeatherUnmarshaller implements UnmarshallerFacade{

    private Weather weather;
    private Iterator<String> weatherElements;
    
    @Override
    public void unmarshallChannel(JsonNode channelNode) {
        this.weatherElements = channelNode.getFieldNames();
        ObjectMapper mapper=new ObjectMapper();
        Units units=mapper.convertValue(buildNodeProperties("units", channelNode), Units.class);
        Atmosphere atmosphere=mapper.convertValue(buildNodeProperties("atmosphere", channelNode), Atmosphere.class);
        Astronomy astronomy=mapper.convertValue(buildNodeProperties("astronomy", channelNode), Astronomy.class);
        Wind wind=mapper.convertValue(buildNodeProperties("wind", channelNode), Wind.class);
        weather=new Weather();
        weather.setWind(wind);
        weather.setUnits(units);
        weather.setAstronomy(astronomy);
        weather.setAtmosphere(atmosphere);
        
        System.out.println("completed");
    }
    
    @Override
    public Map<String,Object> buildNodeProperties(String value, JsonNode node){
        ObjectMapper mapper=new ObjectMapper();
        return mapper.convertValue(node.findValue(value), Map.class);
    }

    @Override
    public void unmarshallItem(JsonNode itemNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Iterator<String> getWeatherElements() {
        return weatherElements;
    }

    public void setWeatherElements(Iterator<String> weatherElements) {
        this.weatherElements = weatherElements;
    }
    
   
    
    
    
    
}
