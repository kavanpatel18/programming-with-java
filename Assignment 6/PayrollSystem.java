import java.time.LocalDate;

public class PayrollSystem {

    public static void main(String[] args) {

        System.out.println("                EMPLOYEE PAYROLL SYSTEM");
        System.out.println("                    FINAL SUMMARY");
        System.out.println();

        FullTimeEmployee ft1 = new FullTimeEmployee(
            1001, "Aditya Sharma", "ABCPS1234D",
            LocalDate.of(2022, 6, 15), "Software Engineer",
            "SWE",
            300000,  // base salary
            40000,   // performance bonus
            0        // hiring commission (not for SWE)
        );

        Payroll p1 = new Payroll(
            100000,  // health insurance
            0,       // bonus already in calcCTC so keeping 0 here
            0,       // stock options
            36000,   // PF (12% of basic)
            15000    // PTO cost
        );
        ft1.setPayroll(p1);

        ContractEmployee ct1 = new ContractEmployee(
            2001, "Rajan Mehta", "CDERM9012F",
            LocalDate.of(2024, 1, 10), "Contract Developer",
            160,    // hours worked in a month
            5000    // rate per hour
        );

        Payroll p2 = new Payroll(0, 0, 0, 0, 0); // no extra benefits for contractors
        ct1.setPayroll(p2);

        Manager m1 = new Manager(
            3001, "Sneha Kulkarni", "DEFSK3456G",
            LocalDate.of(2019, 9, 20), "Engineering Manager",
            300000,  // base salary
            40000,   // performance bonus
            10000,   // travel allowance
            5000     // education allowance
        );

        Payroll p3 = new Payroll(
            100000,  // health insurance
            0,       // bonus already part of calcCTC
            50000,   // stock options
            36000,   // PF
            20000    // PTO cost
        );
        m1.setPayroll(p3);

        System.out.println("============================================================================");
        System.out.printf("%-8s %-20s %-18s %15s %15s%n",
                "EmpID", "Name", "Type", "CTC (Rs)", "Total Cost (Rs)");
        System.out.println("----------------------------------------------------------------------------");

        Employee[] allEmployees = { ft1, ct1, m1 };
        String[] types = { "Full-Time/SWE", "Contract", "Manager" };
        double totalCTC = 0;
        double grandTotal = 0;

        for (int i = 0; i < allEmployees.length; i++) {
            Employee e = allEmployees[i];
            double ctc = e.calcCTC();
            double employerCost = e.totalEmployerCost();
            System.out.printf("%-8d %-20s %-18s %,15.2f %,15.2f%n",
                    e.getEmpId(), e.getName(), types[i], ctc, employerCost);
            totalCTC += ctc;
            grandTotal += employerCost;
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-47s %,15.2f %,15.2f%n", "TOTAL", totalCTC, grandTotal);
        System.out.println("============================================================================");
    }
}
