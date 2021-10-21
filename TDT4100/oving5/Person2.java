package interfaces;

public class Person2 implements Named {
	private String fullName;
	
	public Person2(String fullName) {
		this.fullName = fullName;
	}
	
	public void setGivenName(String name) {
		String[] fullName = this.fullName.split(" ");
		this.fullName = name + " " + fullName[1];
	}
	
	public void setFamilyName(String name) {
		String[] fullName = this.fullName.split(" ");
		this.fullName = fullName[0] + " " + name;
	}
	
	public void setFullName(String name) {
		this.fullName = name;
	}
	
	public String getGivenName() {
		String[] fullName = this.fullName.split(" ");
		return fullName[0];
	}
	
	public String getFamilyName() {
		String[] fullName = this.fullName.split(" ");
		return fullName[1];
	}
	
	public String getFullName() {
		return this.fullName;
	}
}
