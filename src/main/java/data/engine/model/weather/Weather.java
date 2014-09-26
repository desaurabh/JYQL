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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Weather implements Serializable {

    private static final long serialVersionUID = 8146333267353481838L;

    String code;
    String title;
    double latitude;
    double longitude;
    Date publishedDate;
    Date conditionDateTime;
    double celsiusTemprature;
    double fahrenheitTemprature;
    String weatherType;
    List<Forecast> forecast = new ArrayList<Forecast>();
    Astronomy astronomy;
    Atmosphere atmosphere;
    Wind wind;
    Units units;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Date getConditionDateTime() {
        return conditionDateTime;
    }

    public void setConditionDateTime(Date conditionDateTime) {
        this.conditionDateTime = conditionDateTime;
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

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

}
