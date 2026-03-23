public class SavingsAccount extends Account {
    private static final double INTEREST_RATE   = 0.067;
    private static final double MINIMUM_BALANCE = 500.0;

    public SavingsAccount(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance - amount < MINIMUM_BALANCE)
            throw new InsufficientBalanceException(
                "Withdrawal denied: minimum balance of Rs. " + MINIMUM_BALANCE + " must be maintained.");
        balance -= amount;
        System.out.printf("[Savings] Withdrawn : Rs. %.2f  |  Balance : Rs. %.2f%n", amount, balance);
    }

    public void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        System.out.printf("Interest Earned (%.1f%%) : Rs. %.2f%n", INTEREST_RATE * 100, interest);
    }
}
