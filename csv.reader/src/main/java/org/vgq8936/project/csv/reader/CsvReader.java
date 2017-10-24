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
	
	public List<CsvRow> read(InputStream inputStream, List<String> columns) throws IOException {
		List<CsvRow> rows = new ArrayList<CsvRow>();
		Reader in = new InputStreamReader(inputStream);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			CsvRow row = new CsvRow();
			for (int i = 0; i < record.size(); i++) {
				row.getValues().add(new CsvValue(columns.get(i), record.get(i)));
			}
			rows.add(row);
		}
		return rows;
	}

}
