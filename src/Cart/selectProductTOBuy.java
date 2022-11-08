package Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Connection.ConnectionTest;
import User.UserCRUD;

public class selectProductTOBuy {

	public void addCart(int Id, String name, int quantity,String uname) {
		
		String sql1 = "SELECT p_Id,p_name," + quantity + "," + quantity + "*p_price as TOTAL  FROM product WHERE p_id="
				+ Id + " And p_Name ='" + name + "' ";
		try {
			Connection con = ConnectionTest.getConnection();
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String pname = rs.getString(2);
				int pquantity = rs.getInt(3);
				float price = rs.getFloat(4);
				shoppingCart shopping = new shoppingCart(uname, id, pname, pquantity, price);
				insertToCart(shopping);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertToCart(shoppingCart shopping) {
		String sql = "insert into cart (uname,pid,pname,quantity,price)"+ "values(?,?,?,?,?)";
		try {
			Connection con =ConnectionTest.getConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, shopping.getUname());
			ps.setInt(2, shopping.getPid());
			ps.setString(3, shopping.getPname());
			ps.setInt(4, shopping.getQuantity());
			ps.setFloat(5, shopping.getPrice());
			ps.execute();
			con.close();
			ps.close();
			System.out.println("added to cart>>>>>>>>>>>>>>>>>>>");
			UserCRUD u = new UserCRUD();
			u.ListOfproduct(shopping.getUname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
