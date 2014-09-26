package data.engine.model.weather;

import java.io.Serializable;

public class Astronomy implements Serializable {

	
	private static final long serialVersionUID = -7516270971892315887L;
	
	String sunrise;
	String sunset;
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	
	

}
