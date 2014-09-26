package data.engine.model.weather;

import java.io.Serializable;
import java.sql.Date;

public class Forecast implements Serializable {

	private static final long serialVersionUID = 6093561632686113465L;
	
	String code;
	Date date;
	String day;
	int high;
	int low;
	String weatherType;
	
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public String getText() {
		return weatherType;
	}
	public void setText(String text) {
		this.weatherType = text;
	}
	

}
