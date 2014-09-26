package data.engine.model.weather;

import java.io.Serializable;

public class Units implements Serializable{

	private static final long serialVersionUID = 3579830452750837023L;
	
	String distance;
	String pressure;
	String speed;
	char temperature;
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public char getTemperature() {
		return temperature;
	}
	public void setTemperature(char temperature) {
		this.temperature = temperature;
	}
	
	
	
	

}
