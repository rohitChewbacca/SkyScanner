package com.skyscanner.browsegrid.dto;

import java.io.Closeable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BrowseGridResponseApiDto implements Closeable {
	private List<CurrencyDto> currencies;
	private List<ArrayOfCellDto> dates;
	private List<PlaceDto> places;
	private List<CarriersDto> carriers;

//	@XmlElement(name="Currencies")
	@XmlElements({@XmlElement})
	public List<CurrencyDto> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyDto> currencies) {
		this.currencies = currencies;
	}
//	@XmlElement(name="Dates")
	@XmlElements({@XmlElement})
	public List<ArrayOfCellDto> getDates() {
		return dates;
	}

	public void setDates(List<ArrayOfCellDto> dates) {
		this.dates = dates;
	}
//	@XmlElement(name="Places")
	@XmlElements({@XmlElement})
	public List<PlaceDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlaceDto> places) {
		this.places = places;
	}

//	@XmlElement(name="Carriers")
	@XmlElements({@XmlElement})
	public List<CarriersDto> getCarriers() {
		return carriers;
	}

	public void setCarriers(List<CarriersDto> carriers) {
		this.carriers = carriers;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
}
