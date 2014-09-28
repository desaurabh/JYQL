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

package data.engine.model.weather;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author masterOpti
 */
public class Condition implements Serializable{
    
    String code;
    Date date;
    String weatherType;
    double celsiusTemprature;
    double fahrenheitTemprature;
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public double getCelsiusTemprature() {
        return celsiusTemprature;
    }

    public void setCelsiusTemprature(double celsiusTemprature) {
        double fTemp = celsiusTemprature * 9 / 5 + 32;
        this.fahrenheitTemprature = fTemp;
        this.celsiusTemprature = celsiusTemprature;
    }

    public double getFahrenheitTemprature() {
        return fahrenheitTemprature;
    }

    public void setFahrenheitTemprature(double fahrenheitTemprature) {
        double cTemp = fahrenheitTemprature - 32 * 5 / 9;
        this.celsiusTemprature = cTemp;
        this.fahrenheitTemprature = fahrenheitTemprature;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }
    
    
    
}
