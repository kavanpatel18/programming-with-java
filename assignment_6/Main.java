public class Main {
    public static void main(String[] args) {

        try {
            // Full-Time Employee – Software Engineer
            Employee ft1 = new FullTimeEmployee(
                    "Rohan Sharma", "ABCPS1234R", "15-07-2021", "Software Engineer",
                    201, 600000, 80000, 60000, 15000, "SWE"
            );

            // Full-Time Employee – HR
            Employee ft2 = new FullTimeEmployee(
                    "Priya Mehta", "DEFPM5678Q", "01-03-2022", "HR Executive",
                    202, 450000, 60000, 0, 0, "HR"
            );

            // Contract Employee
            Employee ct1 = new ContractEmployee(
                    "Suresh Nair", "GHISN9012W", "10-09-2023", "Contract Developer",
                    203, 160, 350
            );

            // Manager
            Employee m1 = new Manager(
                    "Anjali Verma", "JKLAV3456T", "05-01-2019", "Engineering Manager",
                    204, 900000, 150000, 100000, 50000,
                    40000, 30000
            );

            Employee[] empList = {ft1, ft2, ct1, m1};

            System.out.println("EmpType\tBaseSal\t\tHealthIns\tBonus\t\tOptions\t\tCTC");
            System.out.println("-------\t-------\t\t---------\t-----\t\t-------\t\t---");

            for (Employee e : empList) {
                System.out.printf("%-7s\t%-12.1f\t%-12.1f\t%-12.1f\t%-12.1f\t%.1f%n",
                        e.getEmployeeType(),
                        e.getBaseSalary(),
                        e.getHealthIns(),
                        e.getBonus(),
                        e.getOptions(),
                        e.calcCTC()
                );
            }

        } catch (InvalidEmployeeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }
    }
}
