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
package data.engine.request.builder;

import java.io.BufferedReader;


public interface RequestFacade {
	
	public static String BASE_URL="https://query.yahooapis.com/v1/";
        
        /*
        * Using public allows access only public  data
        */
        public static String PUBLIC="public/yql?q=";
        /*
        * Using O_AUTH allows access to both public and private data
        */
        public static String O_AUTH="yql?=";
        
        public static String FORMAT_XML="&format=xml";
        public static String FORMAT_JSON="&format=json";
        public BufferedReader makeRequest(String query, String format, boolean diagnosticValue);

}
