package studentManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Staff {
	private String username;
	private String password;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
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
	public Staff(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public void creatAcct(Staff s) throws IOException {
		File staffInfo=new File("/Users/tangyuwei/eclipse-workspace/studentManagement/src/studentManagement/adminInfo.txt");
		BufferedWriter out=new BufferedWriter(new FileWriter(staffInfo));
		out.write('\n'+username+',');
		out.write(password);
	}

}
