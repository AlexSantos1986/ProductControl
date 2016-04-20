package ModelClasses;

public class RegisterUsers {
	
	private int userID;
	private String name;
	private String userName;
	private String email;
	private String mobilePhone;
	private String password;
	private String confirmPassword;
	
	
	public RegisterUsers(int userID,String name,String userName, String email, String mobilePhone, String password,String confirmPassword) {
		this.userID = userID;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	

}
