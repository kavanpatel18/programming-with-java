public class Account {
    protected int    accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance       = balance;
        this.customer      = customer;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited : Rs. %.2f  |  New Balance : Rs. %.2f%n", amount, balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance.");
        balance -= amount;
        System.out.printf("Withdrawn : Rs. %.2f  |  Remaining Balance : Rs. %.2f%n", amount, balance);
    }

    public void displayAccount() {
        customer.displayCustomer();
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
    }

    public double getBalance()       { return balance; }
    public int    getAccountNumber() { return accountNumber; }
    public Customer getCustomer()    { return customer; }
}
