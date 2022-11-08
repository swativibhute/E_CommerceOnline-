package User;

import java.util.Scanner;

import Cart.selectProductTOBuy;

public class UserManipulation {

	public void choiceForUser(String uname) {
		System.out.println("enter Your valuable choice>>>>>>>>>");
		System.out.println("1 : Select Product to Buy ");
		System.out.println("2 : exit");
		Scanner sc = new Scanner(System.in);
		
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			 	System.out.println("select product and add to cart");
			 	selectProduct(uname);
			break;
		case 2:
		 	System.out.println("exit");
		break;
		default:
			break;
		}
	}
	
	public void selectProduct(String uname) {
		System.out.println("enter Product id and name and quality for buy>>");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		String name = sc.next();
		int quantity = sc.nextInt();
		selectProductTOBuy select = new selectProductTOBuy();
		select.addCart(id, name,quantity,uname);
	}
	
}
