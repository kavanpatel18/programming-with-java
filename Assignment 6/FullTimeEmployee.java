import java.time.LocalDate;

public class FullTimeEmployee extends Employee {

    protected double baseSalary;
    protected double performanceBonus;
    protected double hiringCommission;
    protected String role;

    public FullTimeEmployee(int empId, String name, String panNo,
                            LocalDate joiningDate, String designation,
                            String role, double baseSalary,
                            double performanceBonus, double hiringCommission) {
        super(empId, name, panNo, joiningDate, designation);
        this.role = role;
        this.baseSalary = baseSalary;
        this.performanceBonus = performanceBonus;
        this.hiringCommission = hiringCommission;
    }

    public double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + performanceBonus;
        } else if (role.equalsIgnoreCase("HR")) {
            return baseSalary + hiringCommission;
        } else {
            return baseSalary;
        }
    }

    public void displayInfo() {
        System.out.println("\n[Full-Time Employee]");
        System.out.println("Role         : " + role);
        System.out.printf("Base Salary  : Rs. %.2f%n", baseSalary);
        if (role.equalsIgnoreCase("SWE")) {
            System.out.printf("Perf. Bonus  : Rs. %.2f%n", performanceBonus);
        }
        if (role.equalsIgnoreCase("HR")) {
            System.out.printf("Hiring Comm. : Rs. %.2f%n", hiringCommission);
        }
        super.displayInfo();
    }
}
