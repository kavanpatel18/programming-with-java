import java.time.Year;

public class MainVehicle{
    public static void main(String[] a){
        Vehicle v = new Vehicle(); 

        Vehicle v1 = new Vehicle("H", "Verna", Year.of(2022), "White", 1550000.00);
        v1.fuelType = 'P';
        v1.seats = 5;
        v1.setMfgCode("HYD22VRN");
        v1.setNoOfServices(3);

        Vehicle v2 = new Vehicle(7, 2400000.00, 'D', "MHD21XUV", 4);
        v2.brand = "Mahindra";
        v2.model = "XUV700";
        v2.yearofMfg = Year.of(2021);
        v2.color = "Blue";

        int newSp = v.accelerate(20);
        System.out.println("New Speed: " + newSp);

        Vehicle[] garage = new Vehicle[3];
        garage[0] = v;
        garage[1] = v1;
        garage[2] = v2;

        System.out.println("Brand\tModel\tYear\tColor\tFuel\tSeats\tPrice\tMileage\tMfgCode\tServices");

        for(int i = 0; i < garage.length; i++){
            garage[i].accelerate(20);
            float m;

            if (garage[i].fuelType == 'D'){
                m = garage[i].calcMileage(50, 500);
            }
            else if (garage[i].fuelType == 'P' || garage[i].fuelType == 'C'){
                m = garage[i].calcMileage(40, 500);
            }
            else{
                m = 0;
            }

            printTabular(garage[i], m);
        } 
    }

    public static void printTabular(Vehicle v, float m){
        System.out.println(
            v.brand + "\t" +
            v.model + "\t" +
            v.yearofMfg + "\t" +
            v.color + "\t" +
            v.fuelType + "\t" +
            v.seats + "\t" +
            v.price + "\t" +
            m + "\t" +
            v.getMfgCode() + "\t" +
            v.getNoOfServices()
        );
    }
}
