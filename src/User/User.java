package User;

public class User {

	private int uId;
	private String uName;
	private String password;
	private String mobile;
	private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", password=" + password + ", mobile=" + mobile + ", email="
				+ email + "]";
	}

}
