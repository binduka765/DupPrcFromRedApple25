package ra_allupdate_apis;

public class GoRestUser {
	//POJO: follows encapsulation - has getters/setters As methods-constructor as well
	
	//all private vars:
	private String name;
	private String email;
	private String gender;
	private String status;
	
	//public constructor... with all vars as Params
	public GoRestUser(String name, String email, String gender, String status) {

		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}

	//public Getters/Setters:
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
