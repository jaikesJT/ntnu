public abstract class AbstractAccount {
    protected double balance;

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        this.internalWithdraw(amount);
    }

    abstract public void internalWithdraw(double amount) throws IllegalStateException;

    public double getBalance() {
        return this.balance;
    }
   
}
