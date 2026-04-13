import java.time.LocalDate;

public abstract class Employee {

    protected int empId;
    protected String name;
    protected String panNo;
    protected LocalDate joiningDate;
    protected String designation;

    protected Payroll payroll;

    public Employee(int empId, String name, String panNo, LocalDate joiningDate, String designation) {
        this.empId = empId;
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    public abstract double calcCTC();

    public void displayInfo() {
        System.out.println("Employee ID  : " + empId);
        System.out.println("Name         : " + name);
        System.out.println("PAN No       : " + panNo);
        System.out.println("Joining Date : " + joiningDate);
        System.out.println("Designation  : " + designation);
        System.out.printf("CTC          : Rs. %.2f%n", calcCTC());
    }

    public double totalEmployerCost() {
        if (payroll != null) {
            return calcCTC() + payroll.totalAdditionalCost();
        }
        return calcCTC();
    }

    public void setPayroll(Payroll p) {
        this.payroll = p;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    // Getters
    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public String getPanNo() { return panNo; }
    public String getDesignation() { return designation; }
    public LocalDate getJoiningDate() { return joiningDate; }
}
