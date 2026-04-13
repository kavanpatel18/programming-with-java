import java.time.LocalDate;

// ContractEmployee extends Employee - Hierarchical Inheritance
// (Both ContractEmployee and FullTimeEmployee extend Employee)
public class ContractEmployee extends Employee {

    private int noOfHours;
    private double hourlyRate;

    public ContractEmployee(int empId, String name, String panNo,
                            LocalDate joiningDate, String designation,
                            int noOfHours, double hourlyRate) {
        super(empId, name, panNo, joiningDate, designation);
        this.noOfHours = noOfHours;
        this.hourlyRate = hourlyRate;
    }

    // Contract employees are paid based on hours worked
    @Override
    public double calcCTC() {
        return noOfHours * hourlyRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n[Contract Employee]");
        System.out.println("Hours Worked : " + noOfHours + " hrs");
        System.out.printf("Hourly Rate  : Rs. %.2f%n", hourlyRate);
        super.displayInfo();
    }
}
