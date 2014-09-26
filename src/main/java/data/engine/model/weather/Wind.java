package data.engine.model.weather;

import java.io.Serializable;

public class Wind implements Serializable{

	private static final long serialVersionUID = -703621805624382359L;
	
	String chill;
	String direction;
	int speed;
	
	public String getChill() {
		return chill;
	}
	public void setChill(String chill) {
		this.chill = chill;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
	

}
