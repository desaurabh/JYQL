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

import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author masterOpti
 */
public class ChannelUnmarshaller implements ChannelFacade{
    
    
    private String data;
    private WeatherUnmarshaller weatherUnmarshaller;

  
    public WeatherUnmarshaller getWeatherUnmarshaller() {
        weatherUnmarshaller=new WeatherUnmarshaller();
        try{
        weatherUnmarshaller.unmarshallChannel(unmarshallResponse().findParent("title"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return weatherUnmarshaller;
        
    }

    public ChannelUnmarshaller(String response){
        this.data=response;
    }
    
    @Override
    public JsonNode unmarshallResponse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(data);
        JsonNode parentNode=node.findParent("results");
        return parentNode.findParent("channel");
    }

  
}
