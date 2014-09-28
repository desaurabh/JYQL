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

package data.engine.response.unmarshaller;

import data.engine.model.weather.*;
import data.engine.parse.utils.DateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        weather=(Weather)unmarshallItems(channelNode);
        JsonNode item=channelNode.findValue("item");
        DateParser dParser=new DateParser();
        Condition condition=new Condition();
        condition.setCode(item.findValue("code").asText());
        condition.setDate(dParser.parseWeatherTimeStamp(item.findValue("date").asText()));
        condition.setFahrenheitTemprature(item.findValue("temp").asDouble());
        condition.setWeatherType(item.findValue("text").asText());
        weather.setLatitude(item.findValue("lat").asDouble());
        weather.setLongitude(item.findValue("long").asDouble());
        weather.setTitle(item.findValue("title").toString());
        weather.setPubDate(dParser.parseWeatherTimeStamp(item.findValue("pubDate").asText()));
        weather.setForecast(unmarshallForecast(item.findValue("forecast")));
        
   }
    
    @Override
    public Map<String,Object> buildModelProperties(String value, JsonNode node){
        ObjectMapper mapper=new ObjectMapper();
        return mapper.convertValue(node.findValue(value), Map.class);
    }

    @Override
    public Object unmarshallItems(JsonNode itemNode) {
        ObjectMapper mapper=new ObjectMapper();
        Units units=mapper.convertValue(buildModelProperties("units", itemNode), Units.class);
        Atmosphere atmosphere=mapper.convertValue(buildModelProperties("atmosphere", itemNode), Atmosphere.class);
        Astronomy astronomy=mapper.convertValue(buildModelProperties("astronomy", itemNode), Astronomy.class);
        Wind wind=mapper.convertValue(buildModelProperties("wind", itemNode), Wind.class);
        Location location=mapper.convertValue(buildModelProperties("location", itemNode), Location.class);
        weather=new Weather();
        weather.setWind(wind);
        weather.setUnits(units);
        weather.setAstronomy(astronomy);
        weather.setAtmosphere(atmosphere);
        weather.setLocation(location);
        return weather;
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
    
   private List<Forecast> unmarshallForecast(JsonNode forecastNode){
       List<Forecast> list=new ArrayList<Forecast>();
       DateParser dParser=new DateParser();
       for(int i=0; i<forecastNode.size(); i++){
           JsonNode node=forecastNode.get(i);
           Forecast forecast=new Forecast();
           forecast.setCode(node.findValue("code").asText());
           forecast.setDay(node.findValue("day").asText());
           forecast.setHigh(node.findValue("high").asDouble());
           forecast.setLow(node.findValue("low").asDouble());
           forecast.setWeatherType(node.findValue("text").asText());
           forecast.setDate(dParser.parseForecastDate(node.findValue("date").asText()));
           list.add(forecast);
       }
       return list;
   }
    
    
    
    
}
