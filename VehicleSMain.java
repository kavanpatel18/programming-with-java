public class VehicleSMain {

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle(1, "Car", "Honda Ciaz", "Petrol");
        Vehicle v2 = new Vehicle(2, "Bike", "Renault", "Petrol");
        Vehicle v3 = new Vehicle(3, "Car", "Kia Seltos", "Diesel");
        Vehicle v4 = new Vehicle(4, "Car", "Maruti Suzuki", "Electric");

        v1.setMfgCode("MH12EK2093");
        v1.setNoOfServices(3);
        v1.calculateMileage(480, 24);

        v2.setMfgCode("GJ18OL0394");
        v2.setNoOfServices(2);
        v2.calculateMileage(350, 10);

        v3.setMfgCode("GJ03OJ3041");
        v3.setNoOfServices(4);
        v3.calculateMileage(600, 30);

        v4.setMfgCode("MG34K0349");
        v4.setNoOfServices(1);
        v4.calculateMileage(420, 70);

        System.out.println("\nVehicle Details and Mileage Comparison\n");

        System.out.printf(
            "%-6s %-8s %-15s %-10s %-10s %-10s %-8s%n",
            "ID", "Type", "Name", "Fuel",
            "MfgCode", "Services", "Mileage"
        );
        System.out.println("--------------------------------------------------------------------");

        v1.displayDetails();
        v2.displayDetails();
        v3.displayDetails();
        v4.displayDetails();
    }
}
