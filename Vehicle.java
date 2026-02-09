public class Vehicle {

    // public members
    public int vehicleId;
    public String vehicleType;

    // private members
    private String vehicleName;
    private String fuelType;
    private String mfgCode;
    private int noOfServices;
    private double mileage;

    // default constructor
    public Vehicle() {
        vehicleId = 0;
        vehicleType = "NA";
        vehicleName = "NA";
        fuelType = "NA";
        mfgCode = "NA";
        noOfServices = 0;
        mileage = 0;
    }

    // parameterized constructor
    public Vehicle(int id, String type, String name, String fuel) {
        vehicleId = id;
        vehicleType = type;
        vehicleName = name;
        fuelType = fuel;
        mfgCode = "NA";
        noOfServices = 0;
    }

    // setters and getters
    public void setVehicleName(String name) {
        vehicleName = name;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setFuelType(String fuel) {
        fuelType = fuel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setMfgCode(String code) {
        mfgCode = code;
    }

    public String getMfgCode() {
        return mfgCode;
    }

    public void setNoOfServices(int services) {
        noOfServices = services;
    }

    public int getNoOfServices() {
        return noOfServices;
    }

    public double getMileage() {
        return mileage;
    }

    // vehicle actions
    public void start() {
        System.out.println(vehicleName + " started");
    }

    public void stop() {
        System.out.println(vehicleName + " stopped");
    }

    public void accelerate() {
        System.out.println(vehicleName + " accelerating");
    }

    // mileage calculation
    public void calculateMileage(double distance, double fuelUsed) {
        mileage = distance / fuelUsed;
    }

    // display method
    public void displayDetails() {
        System.out.printf(
            "%-6d %-8s %-15s %-10s %-10s %-10d %-8.2f%n",
            vehicleId, vehicleType, vehicleName, fuelType,
            mfgCode, noOfServices, mileage
        );
    }
}
