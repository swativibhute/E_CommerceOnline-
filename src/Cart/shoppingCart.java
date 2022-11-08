package Cart;

public class shoppingCart {
	
	private int cid;
	private String uname;
	private int pid;
	private String pname;
	private int quantity;
	private float price;
	
	
	public shoppingCart(String uname, int pid, String pname, int quantity, float price) {
		super();
		this.uname = uname;
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}

	public shoppingCart(int cid, String uname, int pid, String pname, int quantity, float price) {
		super();
		this.cid = cid;
		this.uname = uname;
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}
	
	public shoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
