public class CreditAccount extends AbstractAccount {
    private double creditLine;

    public CreditAccount(double creditLine) throws IllegalArgumentException {
        if (creditLine < 0) {
            throw new IllegalArgumentException("Creditline must be positive");
        }

        this.creditLine = creditLine;
    }

    public void internalWithdraw(double amount) throws IllegalStateException {
        if (this.balance - amount < this.creditLine*-1) {
            throw new IllegalStateException("Balance must not exede credit line");
        }

        this.balance -= amount;
    }

    public double getCreditLine() {
        return this.creditLine;
    }

    public void setCreditLine(double creditLine) throws IllegalStateException {
        if (this.balance < creditLine*-1) {
            throw new IllegalStateException("New creditline must not be smaller than existing balance");
        }

        this.creditLine = creditLine;
    }
}
