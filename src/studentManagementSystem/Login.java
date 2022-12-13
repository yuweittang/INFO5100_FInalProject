package studentManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		BufferedReader in = new BufferedReader(new FileReader("/Users/tangyuwei/eclipse-workspace/studentManagement/src/studentManagementSystem/adminInfo.txt"));
		String str;
		while ((str = in.readLine()) != null) {
			String[] temp=str.split(",");
			System.out.println(temp[0]);
			System.out.println(temp[1]);
			return temp[0].equals(this.username)&& temp[1].equals(this.password);
		}
		return false;
		

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Login lg=new Login("123","123");
		lg.login();
	}

}
