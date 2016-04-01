package com.skyscanner.browsegrid.dto;

import java.io.Closeable;
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaceDto implements Closeable {
	private Long PlaceId;
	private String iataCode;
	private String name;
	private String type;
	private String cityName;
	private String cityId;
	private String countryName;

	public Long getPlaceId() {
		return PlaceId;
	}

	public void setPlaceId(Long placeId) {
		PlaceId = placeId;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
