package allpojos;

public class Credentials {
	
	/**
	 * pojo: plain old java object FOLLOWS ENCAPSULATION
	 * --cannot extend/implement => no parent
	 * --private variables/data fields
	 * --public class constructors
	 * --public methods -- getters/setters
	 * 
	 */
	//i)
	private String username;
	private String password;
	//ii)
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	//iii)getters and setters
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
	

}
