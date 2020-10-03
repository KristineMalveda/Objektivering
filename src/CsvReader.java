import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kristine
 *
 */
public class CsvReader {

	//private static String COMMA_DELIMITER = ",";
	//private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();
	static String[] splitted;
	static String[] params;
	private static final String SPLITTER = ",";
	static ArrayList<CustomerData> customerList = new ArrayList<>();



	public static  ArrayList<CustomerData> loadCSV() {

		/*
		 * try (Scanner scanner = new Scanner(new File("sample.csv"));) { while
		 * (scanner.hasNext()) {
		 * 
		 * wholeSheet.add(getRows(scanner.nextLine()));
		 * 
		 * 
		 * }
		 */

		try {

			BufferedReader br = new BufferedReader(new FileReader("sample.csv"));

			String line;

			int lines = 0;
			while ((line = br.readLine()) != null)
				lines++;
			br.close();
			BufferedReader br1 = new BufferedReader(new FileReader("sample.csv"));

			for (int i = 0; i < lines-1; i++) {

				String myRows = br1.readLine();

				splitted = myRows.split(SPLITTER);
				// Reading values
				CustomerData customerData = new CustomerData();
				customerData.setOrderDate(splitted[0]);
				customerData.setRegion(splitted[1]);
				customerData.setRep1(splitted[2]);
				customerData.setRep2(splitted[3]);
				customerData.setItem(splitted[4]);
				customerData.setUnits(splitted[5]);
				customerData.setUnitCost(splitted[6]);
				customerData.setTotal(splitted[7]);

				customerList.add(customerData);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;

	}

	/*
	 * private static ArrayList<String> getRows(String row) {
	 * 
	 * ArrayList<String> rowValues = new ArrayList<String>(); try (Scanner
	 * rowScanner = new Scanner(row)) { rowScanner.useDelimiter(COMMA_DELIMITER);
	 * while (rowScanner.hasNext()) { rowValues.add(rowScanner.next()); }
	 * 
	 * return rowValues; }
	 * 
	 * }
	 * 
	 * public static void printCSV() { for (ArrayList<String> row : wholeSheet) {
	 * 
	 * System.out.println(row);
	 * 
	 * }
	 * 
	 * }
	 */

}