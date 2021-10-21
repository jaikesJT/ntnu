package interfaces;

public class Person1 implements Named {
	private String givenName;
	private String familyName;
	
	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}
	
	public void setGivenName(String name) {
		this.givenName = name;
	}
	
	public void setFamilyName(String name) {
		this.familyName = name;
	}
	
	public void setFullName(String name) {
		String[] fullName = name.split(" ");
		this.givenName = fullName[0];
		this.familyName = fullName[1];
	}
	
	public String getGivenName() {
		return this.givenName;
	}
	
	public String getFamilyName() {
		return this.familyName;
	}
	public String getFullName() {
		return this.givenName + " " + this.familyName;
	}
}
