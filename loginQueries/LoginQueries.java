package loginQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelClasses.RegisterUsers;

public class LoginQueries {

	private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "33862543";

	Connection conn;

	private PreparedStatement save;
	private PreparedStatement login;

	public LoginQueries() {

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "INSERT INTO Project2.User" + "(name,userName,email,mobilePhone,password,confirmPassword)"
					+ "VALUES(?,?,?,?,?,?)";
			save = conn.prepareStatement(sql);

			String sql1 = "SELECT * FROM Project2.User WHERE userName=? AND password=?";

			login = conn.prepareStatement(sql1);

		} catch (SQLException e) {
			System.out.println("You're not connected to the data base");
			System.exit(1);
		}
	}

	public int addUserLogin(String na, String un, String e, String mp, String p, String confP) {
		int result = 0;

		try {

			save.setString(1, na);
			save.setString(2, un);
			save.setString(3, e);
			save.setString(4, mp);
			save.setString(5, p);
			save.setString(6, confP);

			result = save.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			close();
		}
		return result;

	}

	public List<RegisterUsers> loginUsers(String username, String password) {
		ResultSet rs = null;
		List<RegisterUsers> regUserList = null;

		try {
			login.setString(1, username);
			login.setString(2, password);
			rs = login.executeQuery();

			regUserList = new ArrayList<RegisterUsers>();
			while (rs.next()) {

				regUserList.add(new RegisterUsers(rs.getInt("userID"), rs.getString("name"), rs.getString("userName"),
						rs.getString("email"), rs.getString("mobilePhone"), rs.getString("password"),
						rs.getString("confirmPassword")));
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		} finally {
			try {
				
				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();

				close();
			}
		}
		return regUserList;

	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
