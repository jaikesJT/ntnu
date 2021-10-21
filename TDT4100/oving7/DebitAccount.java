public class DebitAccount extends AbstractAccount {

    public void internalWithdraw(double amount) throws IllegalStateException {
        if (this.balance - amount < 0) {
            throw new IllegalStateException("Account balance cannot go below zero");
        }

        this.balance -= amount;
    }

    
}
