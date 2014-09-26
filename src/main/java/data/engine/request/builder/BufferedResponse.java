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
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class BufferedResponse implements RequestFacade{

	private BufferedReader bufferedReader=null;
	private String jsonResponse=null;
	public BufferedReader getBufferedReader() {
		return this.bufferedReader;
	}

	public BufferedResponse(URL url){
		makeRequest(url);
	}
	
	public BufferedResponse(){
		
	}
	
	@Override
	public void makeRequest(URL url) {
		try {
			this.bufferedReader=new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
		} catch (IOException e) {
			System.out.println("Error occured while opening url stream");
			e.printStackTrace();
		}
		finally{
			if(this.bufferedReader!=null){
				try {
					this.setJsonResponse(IOUtils.toString(this.bufferedReader));
				} catch (IOException e1) {
					System.out.println("Error occured while converting Buffered stream to string");
					e1.printStackTrace();
				}
				try {
					this.bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Error occured while closing the buffered reader");
					e.printStackTrace();
				}
			}	
		}
		
	}

	public String getJsonResponse() {
		return jsonResponse;
	}

	private void setJsonResponse(String jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
	

}
