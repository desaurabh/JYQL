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

package data.engine.model.geo;

import java.io.Serializable;

/**
 *
 * @author masterOpti
 */
public class Place implements Serializable{
    
    int woeid;
    int areaRank;
    int popRank;
    String name;
    PlaceTypeName placeTypeName;
    Centroid centroid;
    BoundingBox boundingBox;
    TimeZone timeZone;

    public int getWoeid() {
        return woeid;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public int getAreaRank() {
        return areaRank;
    }

    public void setAreaRank(int areaRank) {
        this.areaRank = areaRank;
    }

    public int getPopRank() {
        return popRank;
    }

    public void setPopRank(int popRank) {
        this.popRank = popRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceTypeName getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(PlaceTypeName placeTypeName) {
        this.placeTypeName = placeTypeName;
    }

    public Centroid getCentroid() {
        return centroid;
    }

    public void setCentroid(Centroid centroid) {
        this.centroid = centroid;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
    
    
    
    
}
