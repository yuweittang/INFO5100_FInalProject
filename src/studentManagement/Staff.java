package studentManagement;

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

}
