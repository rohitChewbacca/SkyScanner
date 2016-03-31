package com.skyscanner.browsegrid.dto;

import java.util.List;

import javax.ws.rs.Encoded;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BrowseGridResponseApiDto {
	@XmlElement(name="Currencies")
	private List<CurrencyDto> currencies;
	private List<ArrayOfCellDto> dates;
	private List<PlaceDto> places;
	private List<CarriersDto> carriers;

	public List<CurrencyDto> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyDto> currencies) {
		this.currencies = currencies;
	}

	public List<ArrayOfCellDto> getDates() {
		return dates;
	}

	public void setDates(List<ArrayOfCellDto> dates) {
		this.dates = dates;
	}

	public List<PlaceDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlaceDto> places) {
		this.places = places;
	}

	public List<CarriersDto> getCarriers() {
		return carriers;
	}

	public void setCarriers(List<CarriersDto> carriers) {
		this.carriers = carriers;
	}

	public class CellDto {
		private Double minPrice;
		private String dateString;
		private String quoteDateTime;

		public Double getMinPrice() {
			return minPrice;
		}

		public void setMinPrice(Double minPrice) {
			this.minPrice = minPrice;
		}

		public String getDateString() {
			return dateString;
		}

		public void setDateString(String dateString) {
			this.dateString = dateString;
		}

		public String getQuoteDateTime() {
			return quoteDateTime;
		}

		public void setQuoteDateTime(String quoteDateTime) {
			this.quoteDateTime = quoteDateTime;
		}
	}

	public class CarriersDto {
		private Long carrierId;
		private String name;

		public Long getCarrierId() {
			return carrierId;
		}

		public void setCarrierId(Long carrierId) {
			this.carrierId = carrierId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public class PlaceDto {
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
	}

	public class ArrayOfCellDto {
		private List<CellDto> arrayOfCellDto;

		public List<CellDto> getArrayOfCellDto() {
			return arrayOfCellDto;
		}

		public void setArrayOfCellDto(List<CellDto> arrayOfCellDto) {
			this.arrayOfCellDto = arrayOfCellDto;
		}
	}
	public class CurrencyDto {
		@XmlElement(name="code")
		private String code;
		@XmlElement(name="symbol")
		private String symbol;
		@XmlElement(name="thousandsSeparator")
		private Character thousandsSeparator;
		@XmlElement(name="decimalSeparator")
		private Character decimalSeparator;
		@XmlElement(name="symbolOnLeft")
		private Boolean symbolOnLeft;
		@XmlElement(name="")
		private Boolean spaceBetweenAmountAndSymbol;
		@XmlElement(name="")
		private Integer soundingCoefficient;
		@XmlElement(name="")
		private Integer decimalDigits;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public Character getThousandsSeparator() {
			return thousandsSeparator;
		}

		public void setThousandsSeparator(Character thousandsSeparator) {
			this.thousandsSeparator = thousandsSeparator;
		}

		public Character getDecimalSeparator() {
			return decimalSeparator;
		}

		public void setDecimalSeparator(Character decimalSeparator) {
			this.decimalSeparator = decimalSeparator;
		}

		public Boolean getSymbolOnLeft() {
			return symbolOnLeft;
		}

		public void setSymbolOnLeft(Boolean symbolOnLeft) {
			this.symbolOnLeft = symbolOnLeft;
		}

		public Boolean getSpaceBetweenAmountAndSymbol() {
			return spaceBetweenAmountAndSymbol;
		}

		public void setSpaceBetweenAmountAndSymbol(
				Boolean spaceBetweenAmountAndSymbol) {
			this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
		}

		public Integer getSoundingCoefficient() {
			return soundingCoefficient;
		}

		public void setSoundingCoefficient(Integer soundingCoefficient) {
			this.soundingCoefficient = soundingCoefficient;
		}

		public Integer getDecimalDigits() {
			return decimalDigits;
		}

		public void setDecimalDigits(Integer decimalDigits) {
			this.decimalDigits = decimalDigits;
		}
	}
}
