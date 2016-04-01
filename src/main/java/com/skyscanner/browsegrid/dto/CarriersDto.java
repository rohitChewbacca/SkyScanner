package com.skyscanner.browsegrid.dto;

import java.io.Closeable;
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarriersDto implements Closeable {
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

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
