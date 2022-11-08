package Admin;

import java.sql.SQLException;
import java.util.Scanner;

import Product.InsertProduct;
import Product.ProductGET;

public class AdminManupulation {

	public void AdminMaintain() {
		
		System.out.println("1 : Add Product >> ");
		System.out.println("2 : Update Product >>");
		System.out.println("3 : Delete Product >>");
		System.out.println("4 : Product List>>");
		System.out.println("5 : User History >>");
		System.out.println("6 : Product Detail >>");
		System.out.println("Enter choice : ");
		Scanner sc =  new Scanner(System.in);
		int ch = sc.nextInt();
		ProductGET get = new ProductGET();
		InsertProduct p = new InsertProduct();
		while(ch<=6) {
			switch(ch) {
			case 1 : 
					get.adminAddProduct();
					break;
			case 2 :
					try {
						p.updateProduct();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
			case 3 :	
					try {
						p.deleteProduct();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
			case 4: 
					try {
							p.productList();
						} catch (SQLException e) {
							e.printStackTrace();
						}	
					
			}
		}

	}
}
