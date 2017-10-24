package org.vgq8936.project.csv.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CsvReadTestHelper {

	private ClassLoader classLoader;
	
	public CsvReadTestHelper() {
		classLoader = getClass().getClassLoader();
	}
	
	public InputStream fileInputStream(String filename) {
		return classLoader.getResourceAsStream(filename);
	}
	
	public List<CsvColumn> fileColumns(){
		List<CsvColumn> columns = new ArrayList<CsvColumn>();
		columns.add(new CsvColumn("name", false));
		columns.add(new CsvColumn("age", true));
		columns.add(new CsvColumn("grade", false));
		columns.add(new CsvColumn("date", true));
		return columns;
	}
	
	public String[][] defaultValues(){
		String v[][] = {
				{"John","16","7.8","07/07/16"},
				{"Mike","17","8.3","12/05/16"},
				{"Smith","15","9.4","01/01/16"},
				{"Park","18","6.7","31/12/2016"},
				};
		return v;
	}
	
	public String[][] nullValues(){
		String v[][] = {
				{"John",null,"7.8","07/07/16"},
				{"Mike","17","8.3",null},
				{"Smith","15","9.4","01/01/16"},
				{"Park","18","6.7","31/12/2016"},
				};
		return v;
	}
	
}
