package Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductGET {
	
	public  void getProductInformation(String p_Name ,String p_Description,float p_Price,int p_Quantity ) throws SQLException {
		Product product = new Product();
		product.setP_Name(p_Name);
		product.setP_Description(p_Description);
		product.setP_Price(p_Price);
		product.setP_Quantity(p_Quantity);
		
		InsertProduct p = new InsertProduct();
		
		try {
			p.insertIntoProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void adminAddProduct() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Product Inforamtion : ");
		System.out.println("Product Name >> ");
		String p_Name = sc.next();
		
		System.out.println("Product Description >> ");
		String p_Description = sc.next();
		//String strArr[]  = p_Description.split(" ");
		
		Scanner scan = new Scanner(System.in);
		System.out.println(p_Name +"  Price >>" );
		float p_Price = scan.nextFloat();
		
		System.out.println("p_Quantity >>");
		int p_Quantity = scan.nextInt();
		
			try {
				ProductGET p = new ProductGET();
				p.getProductInformation(p_Name, p_Description, p_Price, p_Quantity );
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

}
