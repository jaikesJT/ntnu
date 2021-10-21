public class SavingsAccount2 extends AbstractAccount {
    private int withdrawals;
    private double fee;

    public SavingsAccount2(int withdrawals, double fee) {
        this.withdrawals = withdrawals;
        this.fee = fee;
    }

    public void internalWithdraw(double amount) throws IllegalStateException {
        if (this.balance - amount < 0) {
            throw new IllegalStateException("Account balance cannot go below zero");
        }

        this.balance -= amount;

        if (this.withdrawals == 0) {
            this.balance -= this.fee;
        } else {
            this.withdrawals--;
        }
    }
}
