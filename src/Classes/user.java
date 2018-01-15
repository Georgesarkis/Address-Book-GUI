package Classes;

public class user {

	private String firstName;
	private String lastName;
	private int tel;
	
	public user(String firstName , String lastName, int tel) {
		this.firstName= firstName;
		this.lastName = lastName;
		this.tel = tel;
		
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getTel() {
		return this.tel;
	}
	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.tel + System.lineSeparator() ;
	}
}
