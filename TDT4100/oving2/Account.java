package encapsulation;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		this.setBalance(balance);
		this.setInterestRate(interestRate);
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	
	public void setBalance(double balance) throws IllegalArgumentException {
		if (isValidArgument(balance)) {
			this.balance = balance;
		} else {
			throw new IllegalArgumentException("The balance of '" + balance + "' is invalid");
		}
	}
	
	public void setInterestRate(double interestRate) throws IllegalArgumentException {
		if (isValidArgument(interestRate)) {
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException("The interest rate of '" + interestRate + "' is invalid");
		}
	}
	
	public void deposit(double balance) throws IllegalArgumentException {
		if (isValidArgument(balance)) {
			this.balance += balance;
		} else {
			throw new IllegalArgumentException("It is not possible to deposit the balance of '" + balance + "' to the account");
		}
	}
	
	public void withdraw(double balance) {
		if (isValidArgument(balance) && this.balance >= balance) {
			this.balance -= balance;
		} else {
			throw new IllegalArgumentException("It is not possible to withdraw the balance of '" + balance  + "' from the account"); 
		}
	}
	
	public void addInterest() {
		this.balance += this.balance*(this.interestRate/100);
	}
		
	
	public boolean isValidArgument(double argument) {
		return argument >= 0;
	}
	
	
}
