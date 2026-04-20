import java.io.*;

public class InsertData {
    public static void insertData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data_Student.csv", true));

        writer.write("103,Mihir Desai,AIML,85,79,88,91,83\n");
        writer.write("104,Tanvi Kulkarni,AIML,92,88,94,90,96\n");

        writer.close();
    }
}
