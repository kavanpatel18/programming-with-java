import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            // 1. Create Customers
            ArrayList<Customer> customers = new ArrayList<>();

            Customer c1 = new Customer("C001", "Kavish", "Nag",
                "kavish.nag@gmail.com", "9829326907", "Pune",
                "1234 5678 9101", "ABCDE1234F");

            Customer c2 = new Customer("C002", "Priya", "Sharma",
                "priya.sharma@gmail.com", "9876543210", "Mumbai",
                "9876 5432 1098", "XYZAB5678G");

            Customer c3 = new Customer("C003", "Rohan", "Mehta",
                "rohan.mehta@gmail.com", "9123456789", "Delhi",
                "1234 1234 1234", "PQRST9012H");

            customers.add(c1);
            customers.add(c2);
            customers.add(c3);

            // 2. Create Accounts
            ArrayList<Account> accounts = new ArrayList<>();

            SavingsAccount sa1 = new SavingsAccount(1001, 10000, c1);
            LoanAccount    la1 = new LoanAccount(3001, 120000, 12, c1);
            accounts.add(sa1);
            accounts.add(la1);

            SavingsAccount sa2 = new SavingsAccount(1002, 25000, c2);
            LoanAccount    la2 = new LoanAccount(3002, 60000, 6, c2);
            accounts.add(sa2);
            accounts.add(la2);

            SavingsAccount sa3 = new SavingsAccount(1003, 5000, c3);
            accounts.add(sa3);

            // 3. Perform Transactions
            System.out.println("\n========= Performing Transactions =========");

            System.out.println("\n--- Savings Account (Kavish) ---");
            sa1.deposit(5000);
            sa1.withdraw(3000);
            sa1.calculateInterest();

            System.out.println("\n--- Loan Account (Kavish) ---");
            la1.displayLoan();
            la1.deposit(la1.monthlyEMI);

            System.out.println("\n--- Savings Account (Priya) ---");
            sa2.deposit(10000);
            sa2.withdraw(5000);
            sa2.calculateInterest();

            // 4. Consolidated Summary
            System.out.println("\n========= Customer & Account Summary =========");
            displayConsolidatedInfo(customers, accounts);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void displayConsolidatedInfo(ArrayList<Customer> customers,
                                               ArrayList<Account>  accounts) {
        for (Customer cust : customers) {
            System.out.println("\n==== CUSTOMER DETAILS ====");
            cust.displayCustomer();
            System.out.println("\n---- ACCOUNTS ----");

            double totalBalance = 0;
            int    accountCount = 0;

            for (Account acc : accounts) {
                if (acc.getCustomer().getCustomerID().equals(cust.getCustomerID())) {
                    System.out.println("Account Number : " + acc.getAccountNumber());
                    System.out.println("Account Type   : " + acc.getClass().getSimpleName());
                    System.out.printf("Balance        : Rs. %.2f%n", acc.getBalance());
                    System.out.println();
                    totalBalance += acc.getBalance();
                    accountCount++;
                }
            }
            System.out.println("Total Accounts                    : " + accountCount);
            System.out.printf("Total Balance Across All Accounts : Rs. %.2f%n", totalBalance);
            System.out.println("--------------------------------------------------");
        }
    }
}
