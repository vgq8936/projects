package org.vgq8936.project.csv.reader;

public class CsvColumn {

	private String name;
	
	private boolean allowNull;

	public CsvColumn(String name, boolean allowNull) {
		super();
		this.name = name;
		this.allowNull = allowNull;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAllowNull() {
		return allowNull;
	}

	public void setAllowNull(boolean allowNull) {
		this.allowNull = allowNull;
	}
	
	
}
