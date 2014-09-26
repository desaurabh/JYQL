package data.engine.request.builder;

import java.net.URL;

public interface RequestFacade {
	
	public String baseURL="https://query.yahooapis.com";
	public void makeRequest(URL url);

}
