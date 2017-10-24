package org.vgq8936.project.csv.reader;

public class CsvValue {

	private String columnName;
	
	private String value;
	
	

	public CsvValue(String columnName, String value) {
		super();
		this.columnName = columnName;
		this.value = value;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
