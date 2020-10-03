
public class CustomerData {
	private String orderDate;
	private String region;
	private String rep1;
	private String rep2;
	private String item;
	private String units;
	private String unitCost;
	private String total;
	
	
	public CustomerData(String date) {
		this.orderDate = date;
	
		
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

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
