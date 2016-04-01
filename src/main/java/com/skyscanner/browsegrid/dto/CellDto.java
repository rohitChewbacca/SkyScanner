package com.skyscanner.browsegrid.dto;

import java.io.Closeable;
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CellDto implements Closeable {
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

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
