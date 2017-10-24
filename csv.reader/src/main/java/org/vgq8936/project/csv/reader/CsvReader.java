package org.vgq8936.project.csv.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CsvReader {
	
	private CSVFormat csvFormat;
	
	public CsvReader() {
		this.csvFormat = CSVFormat.DEFAULT;
	}
	
	public CsvReader(CSVFormat csvFormat) {
		this.csvFormat = csvFormat;
	}
	
	public List<CsvRow> read(InputStream inputStream, List<CsvColumn> columns) throws IOException {
		List<CsvRow> rows = new ArrayList<CsvRow>();
		Reader in = new InputStreamReader(inputStream);
		Iterable<CSVRecord> records = csvFormat.parse(in);
		for (CSVRecord record : records) {
			if(record.size() == columns.size()) {
				CsvRow row = new CsvRow();
				for (int i = 0; i < record.size(); i++) {
					CsvColumn csvColumn = columns.get(i);
					String value = record.get(i);
					if(!csvColumn.isAllowNull() && value == null) {
						throw new IllegalArgumentException("Value should not be null");
					}
					row.getValues().add(new CsvValue(csvColumn.getName(), value));
				}
				rows.add(row);
			}
		}
		return rows;
	}

}
