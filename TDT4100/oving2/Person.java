package encapsulation;
import java.util.Date;

public class Person {
	private String name;
	private String email;
	private Date birthday;
	private char gender;
	
	
	public void setName(String name) throws IllegalArgumentException {
		if (isValidName(name)) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("The name '" + name + "' is unvalid");
		}
	}	
	
	public void setEmail(String email) throws IllegalArgumentException {
		if (this.isValidEmail(email)) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("The email '" + email + "' is unvalid");
		}
	}
	
	public void setBirthday(Date birthday) throws IllegalArgumentException {
		if (this.isValidBirthday(birthday)) {
			this.birthday = birthday;
		} else {
			throw new IllegalArgumentException("The birthday cannot be in the future");
		}
	}
	
	public void setGender(char gender) throws IllegalArgumentException {
		if (this.isValidGender(gender)) {
			this.gender = gender;
		} else {
			throw new IllegalArgumentException("The gender '" + gender + "' is unvalid");
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public boolean isValidName(String name) {
		boolean hasWhiteSpace = false;
		
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (!(Character.isLetter(c) || c == ' ')) {
				return false;
			}
			if (c == ' ') {
				hasWhiteSpace = true;
			}
		}
		
		if (!hasWhiteSpace) {
			return false;
		}
		
		String[] parts = name.split(" ");
		String givenName = parts[0];
		String familyName = parts[1];
		
		if (parts.length != 2 || name == null || givenName == null || familyName == null || givenName.length() < 2 || familyName.length() < 2) {
			return false;
		}	
		
		return true;
	}
	
	public boolean isValidEmail(String email) {
		if (email == null) {
			return true;
		}
		
		int a = 0;
		int d = 0;
		
		for (int i = 0; i < email.length(); i++) {
			char c = email.charAt(i);
			if (c == '@') {
				a++;
			} else  if (c == '.') {
				d++;
			}
		}
		
		if (!(a == 1 && d == 2)) {
			return false;
		}
		
		//checks if the pieces of the email corresponds with the name and country code 
		String[] parts = email.split("@");
		
		String[] nameArray = parts[0].split("\\.");
		String fullName = nameArray[0] + " " + nameArray[1];
		
		if (!(this.name.toLowerCase().equals(fullName))) {
			return false;
		}
		
		String[] cc = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", 
				"ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", 
				"ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", 
				"de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", 
				"ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", 
				"hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", 
				"ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", 
				"ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", 
				"na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", 
				"qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", 
				"tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", 
				"va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
		
		String[] domainCountry = parts[1].split("\\.");
		
		boolean validDomain = false;
		
		for (int i = 0; i < cc.length; i++) {
			if (cc[i].equals(domainCountry[1])) {
				validDomain = true;
			}
		}
		
		if (!validDomain) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidBirthday(Date birthday) {
		if (birthday.compareTo(new Date()) > 0) {
			return false;
		}
		return true;
	}
	
	public boolean isValidGender(char gender) {
		return gender == 'M' || gender == 'F' || gender == '\0';
	}
	
	
	
}
