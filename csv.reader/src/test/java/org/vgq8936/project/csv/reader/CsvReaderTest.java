package org.vgq8936.project.csv.reader;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CsvReaderTest {
	
	private CsvReadTestHelper testHelper = new CsvReadTestHelper();

	@Test
    public void testReadFile1() throws IOException{
		InputStream inputStream = testHelper.fileInputStream("file1.csv");
		List<CsvColumn> csvColumns = testHelper.fileColumns();
		
		CSVFormat csvFormat = CSVFormat.EXCEL;
		csvFormat = csvFormat.withFirstRecordAsHeader();
		CsvReader csvReader = new CsvReader(csvFormat);
		
		List<CsvRow> rows = csvReader.read(inputStream, csvColumns);
		String[][] defaultValues = testHelper.defaultValues();
		
		for(int i=0;i < rows.size(); i++) {
			CsvRow csvRow = rows.get(i);
			for(int j=0; j < csvRow.getValues().size(); j++) {
				CsvValue csvValue = csvRow.getValues().get(j);
				assertEquals(defaultValues[i][j],csvValue.getValue());
			}
		}
		
    }
	
	@Test
    public void testReadFile2() throws IOException{
		InputStream inputStream = testHelper.fileInputStream("file2.csv");
		List<CsvColumn> csvColumns = testHelper.fileColumns();

		CSVFormat csvFormat = CSVFormat.EXCEL;
		csvFormat = csvFormat.withFirstRecordAsHeader().withDelimiter(';');
		CsvReader csvReader = new CsvReader(csvFormat);
		
		List<CsvRow> rows = csvReader.read(inputStream, csvColumns);
		String[][] defaultValues = testHelper.defaultValues();
		
		for(int i=0;i < rows.size(); i++) {
			CsvRow csvRow = rows.get(i);
			for(int j=0; j < csvRow.getValues().size(); j++) {
				CsvValue csvValue = csvRow.getValues().get(j);
				assertEquals(defaultValues[i][j],csvValue.getValue());
			}
		}
    }
	
	@Test
    public void testReadFile3() throws IOException{
		InputStream inputStream = testHelper.fileInputStream("file3.csv");
		List<CsvColumn> csvColumns = testHelper.fileColumns();

		CSVFormat csvFormat = CSVFormat.EXCEL;
		csvFormat = csvFormat.withFirstRecordAsHeader().withNullString("");
		CsvReader csvReader = new CsvReader(csvFormat);
		
		List<CsvRow> rows = csvReader.read(inputStream, csvColumns);
		String[][] defaultValues = testHelper.nullValues();
		
		for(int i=0;i < rows.size(); i++) {
			CsvRow csvRow = rows.get(i);
			for(int j=0; j < csvRow.getValues().size(); j++) {
				CsvValue csvValue = csvRow.getValues().get(j);
				assertEquals(defaultValues[i][j],csvValue.getValue());
			}
		}
    }

	@Test(expected= IllegalArgumentException.class)
    public void testReadFile4() throws IOException{
		InputStream inputStream = testHelper.fileInputStream("file4.csv");
		List<CsvColumn> csvColumns = testHelper.fileColumns();

		CSVFormat csvFormat = CSVFormat.EXCEL;
		csvFormat = csvFormat.withFirstRecordAsHeader().withNullString("");
		CsvReader csvReader = new CsvReader(csvFormat);
		
		csvReader.read(inputStream, csvColumns);
		
    }

}
