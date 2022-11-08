package Product;

public class Product {
	private int P_id;
	private String p_Name;
	private String p_Description;
	private float p_Price;
	private int p_Quantity;
	
	
	public Product() {
		super();
	}
	
	public Product(int p_id, String p_Name, String p_Description, float p_Price, int p_Quantity) {
		super();
		this.P_id = p_id;
		this.p_Name = p_Name;
		this.p_Description = p_Description;
		this.p_Price = p_Price;
		this.p_Quantity = p_Quantity;
	}

	public Product(String p_Name, String p_Description, float p_Price, int p_Quantity) {
		super();
		this.p_Name = p_Name;
		this.p_Description = p_Description;
		this.p_Price = p_Price;
		this.p_Quantity = p_Quantity;
	}
	public int getP_id() {
		return P_id;
	}

	public void setP_id(int p_id) {
		P_id = p_id;
	}

	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public String getP_Description() {
		return p_Description;
	}
	public void setP_Description(String p_Description) {
		this.p_Description = p_Description;
	}
	public float getP_Price() {
		return p_Price;
	}
	public void setP_Price(float p_Price) {
		this.p_Price = p_Price;
	}
	public int getP_Quantity() {
		return p_Quantity;
	}
	public void setP_Quantity(int p_Quantity) {
		this.p_Quantity = p_Quantity;
	}
	@Override
	public String toString() {
		return "Product [p_Name=" + p_Name + ", p_Description=" + p_Description + ", p_Price=" + p_Price
				+ ", p_Quantity=" + p_Quantity + "]";
	}

	
	
}
