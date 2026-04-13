import java.time.LocalDate;

// Manager -> FullTimeEmployee -> Employee
public class Manager extends FullTimeEmployee {

    private double travelAllowance;
    private double educationAllowance;

    public Manager(int empId, String name, String panNo,
                   LocalDate joiningDate, String designation,
                   double baseSalary, double performanceBonus,
                   double travelAllowance, double educationAllowance) {
        super(empId, name, panNo, joiningDate, designation,
              "MANAGER", baseSalary, performanceBonus, 0);
        this.travelAllowance = travelAllowance;
        this.educationAllowance = educationAllowance;
    }

    public double calcCTC() {
        return baseSalary + performanceBonus + travelAllowance + educationAllowance;
    }

    public void displayInfo() {
        System.out.println("\n[Manager]");
        System.out.printf("Base Salary  : Rs. %.2f%n", baseSalary);
        System.out.printf("Perf. Bonus  : Rs. %.2f%n", performanceBonus);
        System.out.printf("Travel Allow : Rs. %.2f%n", travelAllowance);
        System.out.printf("Edu. Allow.  : Rs. %.2f%n", educationAllowance);
        System.out.println("--------------------------------------------------");
        System.out.println("Employee ID  : " + empId);
        System.out.println("Name         : " + name);
        System.out.println("PAN No       : " + panNo);
        System.out.println("Joining Date : " + joiningDate);
        System.out.println("Designation  : " + designation);
        System.out.printf("CTC          : Rs. %.2f%n", calcCTC());
        System.out.println("--------------------------------------------------");
    }
}
