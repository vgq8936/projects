package org.vgq8936.project.csv.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CsvReaderTest {
	
	private CsvReader csvReader = new CsvReader(); 

	@Test
    public void testRead() throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("test.csv");
		
		List<String> columnNames = new ArrayList<String>();
		columnNames.add("a");
		columnNames.add("f");
		columnNames.add("w");
		columnNames.add("b");
		columnNames.add("numinst");
		columnNames.add("af");
		columnNames.add("ub");
		
		List<CsvRow> rows = csvReader.read(inputStream, columnNames);
		
		for (CsvRow csvRow : rows) {
			System.out.print("Row: ");
			for (CsvValue csvValue : csvRow.getValues()) {
				System.out.print("  "+ csvValue.getColumnName() + "=" + csvValue.getValue());
			}
		System.out.println();	
		}
    }
}
