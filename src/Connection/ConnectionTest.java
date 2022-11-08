package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static Connection getConnection() throws SQLException {
		
		Connection con = null ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =DriverManager.getConnection("jdbc:mysql://Localhost:3306/eCommerce","root","MySqlroot@12");
			
			 if (con != null) {
				 
			        System.out.println("Connected");
			    }
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return con;

		
	}
}
