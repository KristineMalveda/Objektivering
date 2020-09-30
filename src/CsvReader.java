import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
	String csvFile = "C:\\Users\\Kristine\\Desktop\\advanced-java\\Objektivering\\src\\sample.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	{
	try
	{

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

			// use comma as separator
			String[] customer = line.split(cvsSplitBy);

			
		}

	}catch(
	FileNotFoundException exception)
	{
		exception.printStackTrace();
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
}

