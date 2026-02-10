import java.time.Year;

public class Vehicle {
    public String brand;
    public String model;
    public Year yearofMfg;
    public String color;
    public char fuelType;
    public double price;
    public int seats;
    private String mfgCode;
    private int noOfServices;

    public void setMfgCode(String code){
        mfgCode = code;
    }
    public String getMfgCode(){
        return mfgCode;
    }

    public void setNoOfServices(int nos){
        noOfServices = nos;
    }
    public int getNoOfServices(){
        return noOfServices;
    }

    public Vehicle(){
        brand = "Toyota";
        model = "Glanza";
        yearofMfg = Year.of(2021);
        color = "Red";
        fuelType = 'P';
        seats = 5;
        price = 980000.00;
        mfgCode = "TYT21GLZ";
        noOfServices = 2;
    }

    public Vehicle(String brand, String model, Year yearofMfg, String color, double price){
        this.brand = brand;
        this.model = model;
        this.yearofMfg = yearofMfg;
        this.color = color;
        this.price = price;
    }

    public Vehicle(int seats, double price, char fuelType, String mfgCode, int noOfServices){
        this.seats = seats;
        this.price = price;
        this.fuelType = fuelType;
        this.mfgCode = mfgCode;
        this.noOfServices = noOfServices;
    }

    public int accelerate(int initSp){
        return initSp + 20;
    }

    public float calcMileage(float fuelAmt, float dist){
        return dist / fuelAmt;
    }
}
