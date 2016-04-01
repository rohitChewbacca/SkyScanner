package com.skyscanner.browsegrid.dto;

import java.io.Closeable;
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CurrencyDto implements Closeable {
	private String code;
	private String symbol;
	private Character thousandsSeparator;
	private Character decimalSeparator;
	private Boolean symbolOnLeft;
	private Boolean spaceBetweenAmountAndSymbol;
	private Integer soundingCoefficient;
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

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
