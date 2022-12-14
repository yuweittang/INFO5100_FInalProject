package studentManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Login {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public boolean login() throws IOException {
			MySQLDemo lg=new MySQLDemo();
		    try {
				return lg.getLoginInfo(this.username, this.password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Login lg=new Login("123","123");
		lg.login();
		System.out.println(lg.login());
	}

}
