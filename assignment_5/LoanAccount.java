public class LoanAccount extends Account {
    private double loanAmount;
    private int    totalMonths;
    public double monthlyEMI;
    private int    monthsPaid;

    public LoanAccount(int accountNumber, double loanAmount,
                       int totalMonths, Customer customer) {
        super(accountNumber, 0, customer);
        this.loanAmount  = loanAmount;
        this.totalMonths = totalMonths;
        this.monthlyEMI  = loanAmount / totalMonths;
        this.monthsPaid  = 0;
    }

    @Override
    public void deposit(double amount) {
        double outstanding = loanAmount - (monthsPaid * monthlyEMI);
        if (outstanding <= 0) {
            System.out.println("Loan already fully repaid.");
            return;
        }
        monthsPaid++;
        outstanding -= amount;
        System.out.printf("EMI Paid : Rs. %.2f  |  Outstanding Loan : Rs. %.2f%n",
                          amount, Math.max(0, outstanding));
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        throw new InsufficientBalanceException("Withdrawals are not allowed on Loan Accounts.");
    }

    public void displayLoan() {
        System.out.println("--- Loan Account Details ---");
        customer.displayCustomer();
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Loan Amount    : Rs. %.2f%n", loanAmount);
        System.out.printf("Monthly EMI    : Rs. %.2f%n", monthlyEMI);
        System.out.printf("Tenure         : %d months%n", totalMonths);
        System.out.printf("Months Paid    : %d%n", monthsPaid);
        System.out.printf("Outstanding    : Rs. %.2f%n", Math.max(0, loanAmount - monthsPaid * monthlyEMI));
    }
}
