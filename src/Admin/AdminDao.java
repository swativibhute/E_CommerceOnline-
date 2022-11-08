package Admin;

import java.security.KeyStore.Entry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Connection.ConnectionTest;

public class AdminDao {

	public void insertAdminInfo(AdminMain admin) throws SQLException {

		String sql = "insert into admin(name , password)" + "values(?,?)";
		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, admin.getName());
		ps.setString(2, admin.getPassword());

		int row = ps.executeUpdate();
		System.out.println("*********************Admin registered successfully *********************>>>");
		System.out.println("*********************Welcome to Ecommerce***********************");
		AdminManupulation adminMain = new AdminManupulation();
		adminMain.AdminMaintain();
	}

	public void validateAdmin(AdminMain admin) throws SQLException {
		
		String sql1 = "select * from admin";
		Connection con = ConnectionTest.getConnection();
		PreparedStatement ps1 =con.prepareStatement(sql1);
		ResultSet rs1 = ps1.executeQuery();
		if(!rs1.next()) {
		
			insertAdminInfo(admin);	
		}
		else {
			
			String name = admin.getName();
			String password = admin.getPassword();
			String sql="Select * from admin where name='"+name+"' AND password='"+password+"'";
				PreparedStatement ps =con.prepareStatement(sql);
				ResultSet rs =ps.executeQuery();
				if(rs.next()) {
					System.out.println("************Welcome to eCommerce*************");
					AdminManupulation adminMain = new AdminManupulation();
					adminMain.AdminMaintain();
					
				}else {
					System.out.println("invalid uname And password");
					mainClass main = new mainClass();
					main.DataFromConsole();
				}
		}			
		}

	
}
