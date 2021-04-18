package lab5;



public class ItemProduct {

	
	private static final long serialVersionUID = 1L;
	
	private	int itemProductId;
	private String name;
	private float price;
	
	public void setItemProductId(int itemProductId) {
		
		this.itemProductId = itemProductId;
	}
	
	public int getItemProductId() {
		return this.itemProductId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	
	
	
}
