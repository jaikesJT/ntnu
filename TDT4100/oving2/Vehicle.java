package encapsulation;

public class Vehicle {
	
	private char vehicleType;
	private char fuelType;
	private String regNumber;
	
	public Vehicle(char vehicleType, char fuelType, String regNumber) {		
		this.setVehicleType(vehicleType);
		this.setFuelType(fuelType);
		this.setRegistrationNumber(regNumber);
	}
	
	public char getFuelType() {
		return this.fuelType;
	}
	
	public String getRegistrationNumber() {
		return this.regNumber;
	}
	
	public void setRegistrationNumber(String regNumber) throws IllegalArgumentException {
		if (this.isValidRegNumber(regNumber)) {
			this.regNumber = regNumber;
		} else {
			throw new IllegalArgumentException("Registration number invalid");
		}
		
	}
	
	public char getVehicleType() {
		return this.vehicleType;
	}
	
	public void setVehicleType(char vehicleType) {
		if (this.isValidVehicleType(vehicleType)) {
			this.vehicleType = vehicleType;
		} else {
			throw new IllegalArgumentException("Vehicle type invalid");
		}
	}
	
	public void setFuelType(char fuelType) {
		if (this.isValidFuelType(fuelType)) {
			this.fuelType = fuelType;
		} else {
			throw new IllegalArgumentException("Fuel type invalid");
		}
	}
	
	public boolean isValidVehicleType(char vehicleType) {
		//Type must be either M or C
		return vehicleType == 'C' || vehicleType == 'M';
	}
	
	public boolean isValidFuelType(char fuelType) {
		//A fuel type must be either G, E, D or H
		if (!(fuelType == 'G' || fuelType == 'E' || fuelType == 'D' || fuelType == 'H')) {
			return false;
		}
		//Only cars have H
		if (this.vehicleType == 'M' && fuelType == 'H') {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidRegNumber(String regNumber) {
		//RegNumber of C has 7 symbols and RegNumber of M has 6 numbers
		if ((regNumber.length() != 7 && this.vehicleType == 'C') || (regNumber.length() != 6 && this.vehicleType == 'M')) {
			return false;
		}
		//The two first symbols are capital letters 
		for (int i = 0; i < 2; i++) {
			char c = regNumber.charAt(i);
			if (!(Character.isLetter(c) && Character.isUpperCase(c))) {
				return false;
			}
		}
		
		//After the two first symbols we only have digits 
		for (int i = 2; i < regNumber.length(); i++) {
			char c = regNumber.charAt(i);
			if (!(Character.isDigit(c))) {
				return false;
			}
		}
		//Only vehicles with E or H can have HY, EL or EK
		if (!(this.fuelType == 'E' || this.fuelType == 'H')) {
			if (regNumber.contains("HY") || regNumber.contains("EL") || regNumber.contains("EK")) {
				return false;
			}
		}

		//Must start with "EK" or "EL" if fuel type is E
		if (this.fuelType == 'E' && !(regNumber.contains("EL") || regNumber.contains("EK"))) {
			return false;
		}
		
		//Must start with "HY" if fuel type is H
		if (this.fuelType == 'H' && !(regNumber.contains("HY"))) {
			return false;
		}
		
		
		return true;
	}
	
	
	
}
