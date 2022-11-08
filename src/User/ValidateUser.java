package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Admin.AdminManupulation;
import Admin.mainClass;
import Connection.ConnectionTest;
import Product.InsertProduct;

public class ValidateUser {

	public void checkUser(String uName,String password) throws SQLException {
		
		String sql ="select uName ,password from user where uName='"+uName+"'AND password = '"+password+"'";
		Connection con = ConnectionTest.getConnection();

		PreparedStatement ps =con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		if(rs.next()) {
			System.out.println("------------Login Successful--------------");
			System.out.println("************Welcome to eCommerce*************");
			UserCRUD u = new UserCRUD();
			u.ListOfproduct(uName);
			
		}
		else {
			System.out.println("Invalid userName And password");
			mainClass main = new mainClass();
			System.out.println("1 : Registration");
			System.out.println("2 : Login ");
			System.out.println("enter choice to proceed further>>>");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				UserCRUD u = new UserCRUD();
				u.userInformation();
				break;
			case 2:
				mainClass m = new mainClass();
				m.DataFromConsole();
			default:
				break;
			}

		}
	}
}
