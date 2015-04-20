/*
 * Copyright 2015 masterOpti.
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

import data.engine.model.html.HREF;
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
public class HTMLUnmarshaller implements UnmarshallerFacade{

    private Iterator<String> parentElements;
    private List<HREF> hrefList;

    public List<HREF> getHrefList() {
        return hrefList;
    }
    public void unmarshallChannel(JsonNode channelNode) {
        this.parentElements=channelNode.getFieldNames();
        JsonNode childElements=channelNode.findValue("div");
        unmarshallItems(childElements);
    }

    public Map<String, Object> buildModelProperties(String value, JsonNode node) {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.convertValue(node.findValue(value), Map.class);
    }

    public Object unmarshallItems(JsonNode itemNode) {
        ObjectMapper mapper=new ObjectMapper();
        hrefList=new ArrayList<HREF>();
        for(int i=0; itemNode.size()>i; i++){
            JsonNode node=itemNode.get(i);
            HREF href=mapper.convertValue(buildModelProperties("a", node), HREF.class);
            hrefList.add(href);
        }
        return hrefList;
    }
    
    
    
    
    
}
