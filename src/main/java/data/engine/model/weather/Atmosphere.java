package data.engine.model.weather;

import java.io.Serializable;

public class Atmosphere implements Serializable{

	private static final long serialVersionUID = -2478915406407070376L;

	
	
	double humidity;
	double pressure;
	double visibility;
	double rising;
	
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public double getVisibility() {
		return visibility;
	}
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}
	public double getRising() {
		return rising;
	}
	public void setRising(double rising) {
		this.rising = rising;
	}

	
	
	
	

}
