
public class CustomerData {
	private String orderDate;
	private String region;
	private String rep1;
	private String rep2;
	private String item;
	private int units;
	private double unitCost;
	private double total;
	
	
	public CustomerData() {
		this.orderDate = "";
		this.region= "";
		this.rep1 = "";
		this.rep2= "";
		this.item= "";
		this.units = 0;
		this.unitCost= 0;
		this.total = 0;
		
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRep1() {
		return rep1;
	}

	public void setRep1(String rep1) {
		this.rep1 = rep1;
	}

	public String getRep2() {
		return rep2;
	}

	public void setRep2(String rep2) {
		this.rep2 = rep2;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
