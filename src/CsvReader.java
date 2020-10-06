import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

/**
 * @author Kristine
 *
 */
public class CsvReader {

	static ArrayList<CustomerData> customerList = new ArrayList<>();
	static String csvFile = "sample.csv";
	static CSVReader reader = null;
	static CSVWriter write;
	static FileWriter output;

	public static ArrayList<CustomerData> loadCSV() {

		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] line;
			while ((line = reader.readNext()) != null) {
				// Reading values
				CustomerData customerData = new CustomerData(line[0], line[1], line[2], line[3], line[4], line[5],
						line[6], line[7]);
				customerList.add(customerData);

			}

		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public static void addData(String data1, String data2, String data3, String data4, String data5, String data6,
			String data7, String data8) throws IOException, CsvValidationException {

		

	
		String[] datas = {data1, data2, data3, data4, data5, data6, data7, data8 };
		try {
			loadCSV();
			//reader = new CSVReader(new FileReader(csvFile));
			output = new FileWriter(csvFile, true);
			write = new CSVWriter(output);

			
			CustomerData addData = new CustomerData(data1, data2, data3, data4, data5, data6, data7, data8);
			customerList.add(addData);

			output.append("\r\n");
			output.append(data1);
			output.append(",");
			output.append(data2);
			output.append(",");
			output.append(data3);
			output.append(",");
			output.append(data4);
			output.append(",");
			output.append(data5);
			output.append(",");
			output.append(data6);
			output.append(",");
			output.append(data7);
			output.append(",");
			output.append(data8);
			output.append(",");
			
			
			

			//write.writeNext(datas, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output.flush();
		output.close();

	}
}