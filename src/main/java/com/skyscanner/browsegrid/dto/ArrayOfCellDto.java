package com.skyscanner.browsegrid.dto;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArrayOfCellDto implements Closeable {
	private List<CellDto> arrayOfCellDto;

//	@XmlElement(name="ArrayOfCellDto")
	@XmlElements({@XmlElement})
	public List<CellDto> getArrayOfCellDto() {
		return arrayOfCellDto;
	}

	public void setArrayOfCellDto(List<CellDto> arrayOfCellDto) {
		this.arrayOfCellDto = arrayOfCellDto;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
