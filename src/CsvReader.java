import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * @author Kristine
 *
 */
public class CsvReader {

	
	static ArrayList<CustomerData> customerList = new ArrayList<>();




	public static  ArrayList<CustomerData> loadCSV() {

		String csvFile = "sample.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
            	// Reading values
			CustomerData customerData = new CustomerData(line[0],line[1],line[2],line[3],line[4],line[5],line[6],line[7]);
				customerList.add(customerData);
               
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
		return customerList;

	}

	

}