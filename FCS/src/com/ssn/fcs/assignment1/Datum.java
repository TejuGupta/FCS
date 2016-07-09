package com.ssn.fcs.assignment1;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;

public class Datum implements Comparable<Datum>,Serializable {

	Long sensorID;
	String location;
	Timestamp timeStamp;
	Long temperatureValue;
	Long temperatureUnit;
	public Datum()
	{
		//default constructor
	}
    public Datum(Datum datum)
    {
        this.sensorID=datum.sensorID;
    	this.location=datum.location;
    	this.timeStamp=datum.timeStamp;
    	this.temperatureValue=datum.temperatureValue;
    	this.temperatureUnit=datum.temperatureUnit;
    }
	public Datum(Long sensorID, String location, Timestamp timeStamp, Long temperatureValue, Long temperatureUnit) {
		super();
		this.sensorID = sensorID;
		this.location = location;
		this.timeStamp = timeStamp;
		this.temperatureValue = temperatureValue;
		this.temperatureUnit = temperatureUnit;
	}

	
	public Long getSensorID() {
		return sensorID;
	}

	public void setSensorID(Long sensorID) {
		this.sensorID = sensorID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getTemperatureValue() {
		return temperatureValue;
	}

	public void setTemperatureValue(Long temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	public Long getTemperatureUnit() {
		return temperatureUnit;
	}

	public void setTemperatureUnit(Long temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}

	public int compareTo(Datum compareDatum) {

		Long compareQuantity = compareDatum.getTemperatureValue();
		if (this.temperatureValue - compareQuantity > 0)
			return 1;
		else if (this.temperatureValue - compareQuantity < 0)
			return -1;
		else
			return 0;

	}

	public static Comparator<Datum> DatumComparator = new Comparator<Datum>() {

		public int compare(Datum datum1, Datum datum2) {
			return datum1.compareTo(datum2);

		}

	};
	
	public String toString() {
		  final StringBuilder sb = new StringBuilder();
		  sb.append(this.getSensorID()+",");
		  sb.append(this.getLocation()+",");
		  sb.append(this.getTimeStamp()+",");
		  sb.append(this.getTemperatureValue()+",");
		  sb.append(this.getTemperatureUnit());
		  return sb.toString();
		}

}
