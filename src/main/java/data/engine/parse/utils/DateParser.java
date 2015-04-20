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

package data.engine.parse.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author masterOpti
 */
public class DateParser {
 
    private static String weatherTimeStampDateFormat="EEE, dd MMM yyyy hh:mm a z";
    private static String forecastDateFormat="DD MMM yyyy";
    public DateParser(){
        
    }
    
    public Date parseWeatherTimeStamp(String dateValue){
        return parseDate(weatherTimeStampDateFormat, dateValue);
    }
    
    public Date parseForecastDate(String dateValue){
        return parseDate(forecastDateFormat,dateValue);
    }
    
    
    private static Date parseDate(String dateFormat, String dateValue){
        Date date=new Date();
        try{
             date=new SimpleDateFormat(dateFormat, Locale.ENGLISH).parse(dateValue);
        }
        catch(ParseException e){
            System.out.println("An error has occured unable to parse date "+dateValue+" to format : "+dateFormat);
            e.printStackTrace();
        }
        return date;
    }
    
}
