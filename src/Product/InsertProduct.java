package Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Admin.AdminManupulation;
import Connection.ConnectionTest;

public class InsertProduct {

	public void insertIntoProduct(Product p) throws SQLException {

		String sql = "Insert into product (p_Name,p_Description,p_Price,p_Quantity)" + "values (?,?,?,?)";

		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, p.getP_Name());
		ps.setString(2, p.getP_Description());
		ps.setFloat(3, p.getP_Price());
		ps.setInt(4, p.getP_Quantity());

		int row = ps.executeUpdate();
		if (row > 0) {
			System.out.println(row + " Record inserted");
			AdminManupulation adminMain = new AdminManupulation();
			adminMain.AdminMaintain();
		}
		con.close();
		ps.close();

	}

	public void updateProduct() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Update Product Inforamtion : ");
		System.out.println();
		System.out.println("Enter Product Id >>");
		int p_id = sc.nextInt();
		System.out.println();
		System.out.println("Product Name >> ");
		String p_Name = sc.next();

		System.out.println("Product Description >> ");
		String p_Description = sc.next();
		// String strArr[] = p_Description.split(" ");

		Scanner scan = new Scanner(System.in);
		System.out.println(p_Name + "  Price >>");
		float p_Price = scan.nextFloat();

		System.out.println("p_Quantity >>");
		int p_Quantity = scan.nextInt();
		String sql = "update product set p_name = '" + p_Name + "', p_Description= '" + p_Description + "' ,p_price ='"
				+ p_Price + "' , p_quantity = '" + p_Quantity + "'" + "where p_id = '" + p_id + "'; ";

		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		System.out.println("Record updated successfully");
		AdminManupulation adminMain = new AdminManupulation();
		adminMain.AdminMaintain();
	}

	public void deleteProduct() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Id to delete>>>");
		int p_Id = sc.nextInt();

		String sql = "delete from product where p_Id = '" + p_Id + "'";
		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		System.out.println("Successfully Deleted");
		AdminManupulation adminMain = new AdminManupulation();
		adminMain.AdminMaintain();
	}

	public void productList() throws SQLException {
		String sql = "select * from product ";
		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		demolist(rs);

	}
	public void getList(Product p) {
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(p);
		for (Product product : list) {
			System.out.printf("|%-5d|%-25s|%-25s|%-10f|%-10d|%n",product.getP_id(),product.getP_Name(),product.getP_Description(),product.getP_Price(),product.getP_Quantity());
		}
		
		
	}
	public void demolist(ResultSet rs) throws SQLException {
		System.out.println("***********************////PRODUCT LIST////**********************************************");
		System.out.println("--------------------------------------------------------------------------");
		System.out.printf("|%-5s|%-25s|%-25s|%-10s|%-10s|%n","pId","pName","pDiscription","price","Quantity");
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
		AdminManupulation adminMain = new AdminManupulation();
		adminMain.AdminMaintain();
		
	}
	
	
	
}
