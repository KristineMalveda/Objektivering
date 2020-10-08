import java.util.Comparator;

public class SortbyDate implements Comparator <CustomerData> {
	
	 public int compare(CustomerData a, CustomerData b) 
	    { 
	        return a.getOrderDate().compareTo(b.getOrderDate()); 
	    }

}

