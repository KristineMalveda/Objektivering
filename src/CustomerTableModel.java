import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomerTableModel extends AbstractTableModel {
	
	  private final List<CustomerData> customerList;
	  private final String[] columnNames = new String[] {
			  "OrderDate", "Region", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total" 
	    };
	  
	  private final Class[] columnClass = new Class[] {
			  String.class, String.class, String.class, String.class,
				String.class, String.class, String.class, String.class
		    };
		 
	  public CustomerTableModel(List<CustomerData> customerList)
	    {
	        this.customerList = customerList;
	    }
	     
	    @Override
	    public String getColumnName(int column)
	    {
	        return columnNames[column];
	    }
	 
	    @Override
	    public Class<?> getColumnClass(int columnIndex)
	    {
	        return columnClass[columnIndex];
	    }
	 
	    @Override
	    public int getColumnCount()
	    {
	        return columnNames.length;
	    }
	 
	    @Override
	    public int getRowCount()
	    {
	        return customerList.size();
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    
		
	    {
	        CustomerData row = customerList.get(rowIndex);
	        if(0 == columnIndex) {
	            return row.getOrderDate();
	        }
	        else if(1 == columnIndex) {
	            return row.getRegion();
	        }
	        else if(2 == columnIndex) {
	            return row.getRep1();
	        }
	        else if(3 == columnIndex) {
	            return row.getRep2();
	        }
	        else if(4 == columnIndex) {
	            return row.getItem();
	        }else if(5 == columnIndex) {
	            return row.getUnits();
	        }
	        else if(6 == columnIndex) {
	            return row.getUnitCost();
	        }else if( 7== columnIndex) {
	            return row.getTotal();
	        }
	       
	        return null;
	    }

}
