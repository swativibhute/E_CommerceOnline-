package Admin;

import java.sql.SQLException;
import java.util.Scanner;

import User.UserCRUD;
import User.ValidateUser;

public class mainClass {

	public void checkUser(String name, String password,String type) throws SQLException {
		String Admin="admin";
		String User = "user";
		if(Admin.equals(type)) {
			AdminMain admin = new AdminMain();
			admin.setName(name);
			admin.setPassword(password);
			AdminDao adminDao = new AdminDao();
			try {
				adminDao.validateAdmin(admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(User.equals(type)){
			ValidateUser validate = new ValidateUser();
			validate.checkUser(name,password);
		}
	}
	public void DataFromConsole() {
		
		System.out.println("Enter Your Name>>");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("enter password >>");
		String password = sc.next();
		System.out.println("enter type");
		String type = sc.next();
		try {
			checkUser(name, password,type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		mainClass main = new mainClass();
		main.DataFromConsole();
		
	}
}
