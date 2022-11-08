package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Admin.AdminManupulation;
import Connection.ConnectionTest;
import Product.Product;

public class UserCRUD {
	
	public void userInformation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Your name:");
		String uName = sc.next();
		System.out.println("enter password :");
		String password = sc.next();
		System.out.println("mobile number :");
		String mobile = sc.next();
		System.out.println("enter Email :");
		String email = sc.next();
	
		User user = new User();
		user.setuName(uName);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setEmail(email);
		insertUser(user);
	}
	
	public void insertUser(User u) {
		String sql = "insert into user (uname,password,email,mobile)"+"values(?,?,?,?)";
		try {
			Connection con = ConnectionTest.getConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, u.getuName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getMobile());
			ps.setString(4, u.getMobile());
			
			ps.execute();
			con.close();
			ps.close();
			System.out.println("-------------Registration successful--------------");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	public void ListOfproduct(String uname) throws SQLException {
		String sql = "select * from product ";
		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		demolist(rs,uname);

	}
	public void getList(Product p) {
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(p);
		for (Product product : list) {
			System.out.printf("|%-5d|%-25s|%-25s|%-10f|%-10d|%n",product.getP_id(),product.getP_Name(),product.getP_Description(),product.getP_Price(),product.getP_Quantity());
		}
		
	}
	public void demolist(ResultSet rs,String uname) throws SQLException {
		System.out.println("***********************////PRODUCT LIST////**********************************************");
		System.out.println("--------------------------------------------------------------------------");
		System.out.printf("| %-5s| %-25s| %-25s| %-10s| %-10s| %n ","pId","pName","pDiscription","price","Quantity");
		System.out.println("--------------------------------------------------------------------------");
		while (rs.next()) {
			int p_Id =rs.getInt(1);
			String p_Name=rs.getString(2);
			String p_Description=rs.getString(3);
			float p_Price =rs.getFloat(4);
			int p_Quantity =rs.getInt(5);
			Product p  = new Product(p_Id, p_Name, p_Description, p_Price, p_Quantity);
			getList(p);
		}
		System.out.println("--------------------------------------------------------------------------");
		
		UserManipulation u = new UserManipulation();
		u.choiceForUser(uname);
	}
	
	
	
	
	
	
	
	
}
